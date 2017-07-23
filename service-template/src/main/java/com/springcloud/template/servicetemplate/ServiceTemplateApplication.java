package com.springcloud.template.servicetemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@EnableBinding
@EnableHystrix
@EnableHystrixDashboard
@EnableResourceServer
//prePostEnabled 启用spring express的语法进行访问限制
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RestController
public class ServiceTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTemplateApplication.class, args);
	}

	@RequestMapping(path = "/hello")
	@PreAuthorize("isAuthenticated()")
	public String sayHello(){
		return "hello world";
	}
}
