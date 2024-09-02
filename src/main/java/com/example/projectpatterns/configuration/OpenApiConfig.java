package com.example.projectpatterns.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {
    private OpenAPI openAPI = new OpenAPI();
    @Bean
    public OpenAPI customOpenAPI() {
        return  openAPI
                .info(customInfo());
    }

    private Info customInfo() {
        return new Info()
                .title("Project Patterns")
                .version("0.0.1");
    }
}