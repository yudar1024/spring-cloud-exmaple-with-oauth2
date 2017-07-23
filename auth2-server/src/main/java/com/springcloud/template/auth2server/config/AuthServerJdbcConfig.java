package com.springcloud.template.auth2server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import javax.sql.DataSource;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by chenluo on 2017/1/20.
 */
@Configuration
@EnableResourceServer
@EnableAuthorizationServer
public class AuthServerJdbcConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    @Qualifier("customUserDetailService")
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService);

    }




//
//    public static void main(String [] test){
//        System.out.print(getPasswordEncod().encode("tester"));
//    }


}
