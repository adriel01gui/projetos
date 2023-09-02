package com.java.inspSaude.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.java.inspSaude.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(info());

    }

    private ApiInfo info() {
        return new ApiInfo("Militares-API",
                "Documentação de Militares",
                "1.0",
                "",
                new Contact("Adriel", "localhost:8081", ""),
                "", "", Collections.emptyList());

    }
}