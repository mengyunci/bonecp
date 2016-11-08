package com.unknow;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by mac on 16/3/1.
 */
//@Configuration
//@EnableTransactionManagement
//@MapperScan("com.unknow.mapper")
public class DataSourceConfig {

//    @Bean
//    @ConfigurationProperties(prefix = "wbm")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//    @Bean
//    public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception{
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        Interceptor interceptor = new PageHelper();
//        factoryBean.setPlugins(new Interceptor[]{interceptor});
//        return factoryBean.getObject();
//    }
//
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sessionFactory) {
//        return new SqlSessionTemplate(sessionFactory);
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }


}
