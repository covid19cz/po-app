package cz.covid.po.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConversionConfig {

    @Bean
    public DefaultConversionService defaultConversionService() {
        return new DefaultConversionService();
    }
}
