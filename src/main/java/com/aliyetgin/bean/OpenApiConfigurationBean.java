package com.aliyetgin.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class OpenApiConfigurationBean {

    @Bean
    public OpenAPI openAPIMethod() {
        return new OpenAPI().info(new Info()
                .title("title info")
                .description("description info")
                .version("V1.0")
                .contact(new Contact()
                        .name("Ali")
                        .url("www.aliyetgin.com.tr")
                        .email("aliyetgin@gmail.com"))
                .termsOfService(" Software INC.")
                .license(new License()
                        .name("Licence ")
                        .url("www."))
        );
    }
}

//localhost:3333/swagger-ui.html
//swagger: API Document
