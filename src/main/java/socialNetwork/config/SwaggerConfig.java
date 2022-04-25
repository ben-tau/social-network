package socialNetwork.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket formationSpringApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("socialNetwork.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Social Network SPRING API",
                "Some custom description of API.",
                "1.0",
                "Terms of service",
                new Contact("DM", "www.dm.com", "dm@dm.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
   
}