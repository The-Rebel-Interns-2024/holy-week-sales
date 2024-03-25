package com.serbatic.holyweeksales.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info()
                .title("Spring Boot sales API REST")
                .version("1.0")
                .description("Sales API REST DOCS")
                .termsOfService("http://google.com"));
    }
}
