package com.springcloud.template.zuulserverwithoauth2jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerJwtConfig extends ResourceServerConfigurerAdapter{

    @Autowired
    @Qualifier("tokenStore")
    private TokenStore tokenStore;


    @Autowired
    JwtAccessTokenConverter tokenConverter;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                authorizeRequests().antMatchers("/auth2jwt/**").permitAll()
//                .antMatchers("/resjwt/**").permitAll()
//                .antMatchers("/jwtfgn/**").permitAll()
                .anyRequest().authenticated();

    }

    // cors 设置方案。对于微服务体系，在网关zuul 这里设置cors就可以了，如果在其他微服务也设置了cors 那么在最终的返回response中，就有有两条甚至3条同名的header Access-Control-Allow-Origin
//    造成The 'Access-Control-Allow-Origin' header contains multiple values 错误。原因是每个微服务都在response 当中添加了Access-Control-Allow-Origin z
//    如果在非网关微服务也想启用cors，需要在URL 上进行设计，一般的方法是/authsec/v1/<微服务代码>/**
//    注意网关服务和微服务之间URL 的变化，假设服务A 在网关被定义为 /AA,在微服务A上有一个API url 为/authsec/v1/codea/
//    从客户端访问的url 就是/AA/authsec/v1/codea/xxx ,微服务A 实际收到的URL 为/authsec/v1/codea/xxx
//    注意***************** zuul 和authserver 的权限相关配置不能放到jar包里，引用通用配置，只能放在各自的微服务中，不然无法生效。
    @Bean
    public FilterRegistrationBean corsFilter () {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);//这个设置是关键，没有这个设置启动不了，而且实际也不会生效
        return bean;
    }
}
