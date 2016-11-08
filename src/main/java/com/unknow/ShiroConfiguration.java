package com.unknow;

import com.unknow.realm.UserRealm;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mac on 16/3/21.
 */
//@Configuration
public class ShiroConfiguration {

    @Bean
    public EhCacheManager getCache() {
        EhCacheManager manager = new EhCacheManager();
        manager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return manager;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filter.addInitParameter("targetFilterLifecycle","true");
        filter.setEnabled(true);
        filter.addUrlPatterns("/*");
        filter.setOrder(0);
        filter.setDispatcherTypes(DispatcherType.ASYNC,DispatcherType.FORWARD,DispatcherType.INCLUDE);
        return filter;
    }




    @Bean(name = "userRealm")
    public UserRealm getUserRealm(PasswordMatcher matcher, EhCacheManager manager) {
        UserRealm realm = new UserRealm();
        realm.setCacheManager(manager);
        realm.setAuthenticationCachingEnabled(true);
        realm.setAuthenticationCacheName("authenticationCache");
        realm.setAuthorizationCachingEnabled(true);
        realm.setAuthorizationCacheName("authorizationCache");
        realm.setCredentialsMatcher(matcher);
        return realm;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getSecurity(@Qualifier("userRealm") Realm realm, EhCacheManager ehCacheManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        manager.setCacheManager(ehCacheManager);
        return manager;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShrioFilterBean(DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/");
        bean.setUnauthorizedUrl("/login?error");


        // FIXME 这些后期可以从配置文件读取

        Map<String,String> chainDefinitionMap = new HashMap<>();
        chainDefinitionMap.put("/**","authc");
        chainDefinitionMap.put("/login","anon");
        chainDefinitionMap.put("/css/**","anon");
        chainDefinitionMap.put("/js/**","anon");
        chainDefinitionMap.put("/images/**","anon");
        chainDefinitionMap.put("/logout","anon");

        bean.setFilterChainDefinitionMap(chainDefinitionMap);
        return bean;


    }

    // 密码加密服务,目前使用Shiro提供的默认方式,后期可以改为配置方式
    @Bean
    public PasswordService getPasswordService() {
        return new DefaultPasswordService();
    }

    @Bean
    public PasswordMatcher getPasswordMatcher(PasswordService service) {
        PasswordMatcher matcher = new PasswordMatcher();
        matcher.setPasswordService(service);
        return matcher;
    }

}
