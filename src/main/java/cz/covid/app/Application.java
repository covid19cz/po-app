package cz.covid.app;

import cz.covid.config.DatabaseConfig;
import cz.covid.config.SecurityConfig;
import cz.covid.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DatabaseConfig.class, SwaggerConfiguration.class, SecurityConfig.class})
@ComponentScan(basePackages = {"cz.covid.service", "cz.covid.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
