package com.wipro.favourites_service.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerConfig {
	
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.wipro.favourites_service")).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
		
	}
	
	
	private ApiInfo apiInfo() {
		
		ApiInfoBuilder apiInfoBuilder=new ApiInfoBuilder();
		return apiInfoBuilder.title("Favourite News API")
		.description("Swagger for News Capstone")
		.contact("rvsaikrishna55@gmail.com").license("rvsaikrishna55@gmail.com")
		.licenseUrl("rvsaikrishna55@gmail.com").version("v1.0.1").build();
		
		
	}



}
