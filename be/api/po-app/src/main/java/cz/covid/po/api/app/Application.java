package cz.covid.po.api.app;

import cz.covid.po.api.config.ConversionConfig;
import cz.covid.po.api.config.DatabaseConfig;
import cz.covid.po.api.config.ObjectMapperConfig;
import cz.covid.po.api.config.SecurityConfig;
import cz.covid.po.api.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DatabaseConfig.class, SwaggerConfiguration.class, SecurityConfig.class, ObjectMapperConfig.class, ConversionConfig.class})
@ComponentScan(basePackages = {"cz.covid.po.api.bl.service", "cz.covid.po.api.controller", "cz.covid.po.api.converter", "cz.covid.po.api.integration"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
