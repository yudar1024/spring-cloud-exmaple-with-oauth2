/**
 *  author chen roger
 */

package com.springcloud.template.common.security.jwt;

import com.springcloud.template.common.security.jwt.Interceptor.MyOAuth2FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GlobalMethodSecurityConfiguration {

    @Bean
    public RequestInterceptor oAuth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext){
        return new MyOAuth2FeignRequestInterceptor(oAuth2ClientContext);
    }

}
