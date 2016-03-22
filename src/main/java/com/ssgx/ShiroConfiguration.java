package com.ssgx;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mac on 16/3/21.
 */
@Configuration
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
        filter.setFilter(new DelegatingFilterProxy("shrioFilter"));
        filter.addInitParameter("targetFilterLifecycle","true");
        filter.setEnabled(true);
        filter.addUrlPatterns("/*");
        filter.setOrder(0);
        filter.setDispatcherTypes(DispatcherType.ASYNC,DispatcherType.FORWARD,DispatcherType.INCLUDE);
        return filter;
    }


    /**
     * 试用Shrio提供的JdbcRealm进行用户身份验证,此处可以配置密码加密策略或者盐等
     * @param wbm 数据库连接
     * @param matcher 密码匹配策略
     * @return
     */
    @Bean(name = "jdbcReaml")
    public JdbcRealm getRealm(@Qualifier("wbm")DataSource wbm,PasswordMatcher matcher,EhCacheManager manager) {
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(wbm);
        realm.setCredentialsMatcher(matcher);
        // 查询用户的密码,不使用默认方式
        realm.setAuthenticationQuery("select password from users where username = ? and enabled = 1");
        realm.setCacheManager(manager);
        return realm;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getSecurity(JdbcRealm reaml,EhCacheManager ehCacheManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(reaml);
        manager.setCacheManager(ehCacheManager);
        return manager;
    }

    @Bean(name = "shrioFilter")
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

    // 密码加密服务,目前使用Shrio提供的默认方式,后期可以改为配置方式
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
