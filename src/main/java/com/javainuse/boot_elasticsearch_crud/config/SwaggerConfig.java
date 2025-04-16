package com.javainuse.boot_elasticsearch_crud.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {
    @Bean
    public OpenAPI getOpenAPI() {

        Contact contact = new Contact();
        contact.name("Gabriel Thiago");
        contact.email("gabrielfernandesthiago@hotmail.com");

        Info info = new Info();
        info.setTitle("Papyrus Query API");
        info.setVersion("v1");
        info.description("API for Papyrus Query Web Application to Search Wikipedia Documents Using Advanced Querys With Elasticsearch");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
