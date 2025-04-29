package com.srivatsan177.sioverflow.app.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SI-Overflow API")
                        .version("1.0")
                        .description("API Documentation for SI-Overflow")
                        .contact(new Contact()
                                .name("Srivatsan Iyengar")
                                .email("ksrivatsan177@gmail.com")))
                .addServersItem(new Server().url("/").description("Default Server URL"));
    }
}
