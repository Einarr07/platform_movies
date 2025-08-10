package com.platform.movies.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Movies API")
                        .description("Documentación de la API de películas")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Mateo Congo")
                                .email("mateo-sebas_11@outlook.com")));
    }
}
