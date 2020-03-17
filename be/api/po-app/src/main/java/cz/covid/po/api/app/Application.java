package cz.covid.po.api.app;

import cz.covid.po.api.config.DatabaseConfig;
import cz.covid.po.api.config.SecurityConfig;
import cz.covid.po.api.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DatabaseConfig.class, SwaggerConfiguration.class, SecurityConfig.class})
@ComponentScan(basePackages = {"cz.covid.po.api.service", "cz.covid.po.api.controller", "cz.covid.po.api.converter"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
