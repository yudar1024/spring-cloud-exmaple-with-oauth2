package com.springcloud.template.auth2server;

import com.springcloud.template.auth2server.config.AuthServerJdbcConfig;
import com.springcloud.template.auth2server.config.ClientConfig;
import com.springcloud.template.auth2server.config.JPAConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringCloudApplication
@EnableBinding
@EnableHystrix
@Import({AuthServerJdbcConfig.class, JPAConfig.class, ClientConfig.class})
@ComponentScan({"com.springcloud.template"})
public class Auth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Auth2ServerApplication.class, args);
	}
}
