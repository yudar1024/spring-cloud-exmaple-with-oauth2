package com.springcloud.template.saserver;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@EnableAdminServer
public class SaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaServerApplication.class, args);
	}
}
