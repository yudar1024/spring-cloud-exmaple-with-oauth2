package com.springcloud.template.resourceservicejwt;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@Slf4j
@ComponentScan("com.springcloud.template")
@EnableCircuitBreaker
public class ResourceServiceJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceJwtApplication.class, args);
	}
}
