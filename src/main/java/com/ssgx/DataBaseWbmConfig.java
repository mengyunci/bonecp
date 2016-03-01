package com.ssgx;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by mac on 16/3/1.
 */
@Configuration
public class DataBaseWbmConfig {

    @Bean(name = "wbm")
    @ConfigurationProperties(prefix = "wbm")
    public DataSource wbmDataSource() {
        return DataSourceBuilder.create()
                .type(BoneCPDataSource.class)
                .build();
    }



    @Bean(name = "ssgx")
    @Primary
    @ConfigurationProperties(prefix = "ssgx")
    public DataSource ssgxDataSource() {
        return DataSourceBuilder.create()
                .type(BoneCPDataSource.class)
                .build();
    }


    @Bean(name = "wbmJdbc")
    public JdbcTemplate wbmJdbcTemplate(@Qualifier("wbm")DataSource wbm) {
        return new JdbcTemplate(wbm);
    }

    @Bean(name = "mesJdbc")
    public JdbcTemplate jdbcTemplate(@Qualifier("ssgx") DataSource ssgx) {
        return new JdbcTemplate(ssgx);
    }

}
