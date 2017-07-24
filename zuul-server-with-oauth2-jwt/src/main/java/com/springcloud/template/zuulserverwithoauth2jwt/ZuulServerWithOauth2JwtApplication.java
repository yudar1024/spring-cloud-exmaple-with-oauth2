/**
 * 在 jwt 的场景中 Zuul 不需要做为resource server，仅仅启用 websecurity 即可，然后只允许微服务暴露的url 即可
 */
package com.springcloud.template.zuulserverwithoauth2jwt;

import com.springcloud.template.zuulserverwithoauth2jwt.config.GlobalMethodSecurityConfiguration;
import com.springcloud.template.zuulserverwithoauth2jwt.config.JwtConfiguration;
import com.springcloud.template.zuulserverwithoauth2jwt.config.ResourceServerJwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringCloudApplication
@EnableZuulProxy
@ComponentScan({"com.springcloud.template.zuulserverwithoauth2jwt"})
@Import({ResourceServerJwtConfig.class, JwtConfiguration.class, GlobalMethodSecurityConfiguration.class})
public class ZuulServerWithOauth2JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerWithOauth2JwtApplication.class, args);
	}
}
