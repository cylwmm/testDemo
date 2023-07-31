package com.cyl.learn.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                useDefaultResponseMessages(false).
                select().
                apis(RequestHandlerSelectors.any()).
                paths(PathSelectors.any()).
                build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                title("接口文档服务").
                contact(new Contact("作者", "地址", "联系方式")).
                description("接口文档服务").
                version("1.0").build();
    }
}
