package com.springcloud.template.zuulserverwithauth2;

import com.springcloud.template.zuulserverwithauth2.config.GlobalMethodSecurityConfiguration;
import com.springcloud.template.zuulserverwithauth2.config.ResourceServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@EnableZuulProxy
@ComponentScan({"com.springcloud.template"})
@RestController
//@Import(value = {ResourceServerConfig.class, GlobalMethodSecurityConfiguration.class})
public class ZuulServerWithAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerWithAuth2Application.class, args);
	}

	@RequestMapping("/helloz")
	public String getMsg(){
		return "zuul message";
	}
}
