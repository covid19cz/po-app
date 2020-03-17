package cz.covid.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile("postgres")
public class PostgresConfig {

    @Value("${postgres.url}")
    private String postgresUrl;

    @Value("${postgres.username}")
    private String postgresUsername;

    @Value("${postgres.password}")
    private String postgresPassword;

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("org.postgresql.Driver");
        hikariDataSource.setJdbcUrl(postgresUrl);
        hikariDataSource.setUsername(postgresUsername);
        hikariDataSource.setPassword(postgresPassword);
        hikariDataSource.setMaximumPoolSize(50);

        return hikariDataSource;
    }

    @Bean
    public Properties jpaProperties() {
        Properties props = new Properties();
        props.put("hibernate.query.substitutions", "true 'Y', false 'N'");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "false");
        props.put("hibernate.format_sql", "true");
        return props;
    }

}
