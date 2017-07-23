package com.springcloud.template.common.security.lib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class CommonConfig {

    @Bean
    public static PasswordEncoder getPasswordEncod(){
        Integer seed= 9;
        return  new BCryptPasswordEncoder(8, new SecureRandom(seed.toString().getBytes()));
    }
}
