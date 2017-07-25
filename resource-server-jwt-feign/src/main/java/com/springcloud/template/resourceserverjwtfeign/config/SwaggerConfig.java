package com.springcloud.template.resourceserverjwtfeign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * ClassName:SwaggerConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: Sep 19, 2016 8:48:11 AM <br/>
 * 
 * @author roger
 * @version
 * @since JDK 1.8
 * @see
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("database")
				.apiInfo(apiInfo())
				.genericModelSubstitutes(DeferredResult.class)
				.useDefaultResponseMessages(false)
				.forCodeGeneration(true)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.springcloud.template.resourceserverjwtfeign.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("foxcloud database management")
				.description("fox database core API")
				.contact(new Contact("roger chen", "http://www.google.com", "luo-jie.chen@hpe.com"))
				.version("0.1")
				.build();
	}

}
