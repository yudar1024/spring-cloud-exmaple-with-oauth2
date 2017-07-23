/**
 * zuul 其实也是一个resourceserver， 在oauth2 体系中只有4个角色 resource owner, client, resource server, authorization server. client 由post man 扮演，owner 由用户名密码扮演， 出了authorization server 之外
 * 其他都是resource server。
 */

package com.springcloud.template.authserverjwt;

import com.springcloud.template.authserverjwt.config.OAuth2Configuration;
import com.springcloud.template.authserverjwt.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableBinding
@EnableHystrix
@Import({OAuth2Configuration.class, WebSecurityConfig.class})
@ComponentScan({"com.springcloud.template"})
public class AuthServerJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerJwtApplication.class, args);
	}
}
