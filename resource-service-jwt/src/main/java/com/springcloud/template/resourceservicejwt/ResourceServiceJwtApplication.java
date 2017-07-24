package com.springcloud.template.resourceservicejwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringCloudApplication
@Slf4j
@ComponentScan("com.springcloud.template")
public class ResourceServiceJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceJwtApplication.class, args);
	}
}
