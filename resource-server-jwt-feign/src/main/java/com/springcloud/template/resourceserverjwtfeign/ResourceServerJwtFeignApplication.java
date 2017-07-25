package com.springcloud.template.resourceserverjwtfeign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.springcloud.template.resourceserverjwtfeign.feign"})
@ComponentScan("com.springcloud.template")
public class ResourceServerJwtFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerJwtFeignApplication.class, args);
	}

//	@Bean
//	@Autowired
//	public RequestInterceptor oauth(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails){
//		return new OAuth2FeignRequestInterceptor(oAuth2ClientContext,oAuth2ProtectedResourceDetails);
//
//	}
}
