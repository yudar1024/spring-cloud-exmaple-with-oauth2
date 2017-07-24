package com.springcloud.template.resourceserverjwtfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.springcloud.template.resourceserverjwtfeign.feign"})
public class ResourceServerJwtFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerJwtFeignApplication.class, args);
	}
}
