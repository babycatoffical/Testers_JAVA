package org.babycat.testers.repository.jdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
class JDBCConfiguration {
    @Bean("")
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        return new DataSourceBuilder().create().build();
    }
}
