package com.epam.guest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * The type Swagger config.
 */
@Configuration
public class SwaggerConfig {
    /**
     * Gets docket.
     *
     * @return the docket
     */
    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Public-API")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Guest Service ")
                .description("Guest Service API ")
                .build();
    }

}