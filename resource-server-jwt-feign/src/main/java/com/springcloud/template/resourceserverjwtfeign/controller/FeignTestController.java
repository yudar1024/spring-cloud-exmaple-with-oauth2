package com.springcloud.template.resourceserverjwtfeign.controller;

import com.springcloud.template.resourceserverjwtfeign.feign.ResourceServerJwtClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignTestController {

    @Autowired
    private ResourceServerJwtClient resourceServerJwtClient;

    @RequestMapping("/feign/hello")
    public String feignHello(){
        log.info("feign hello");
        return resourceServerJwtClient.helloJwt();

    }
    @RequestMapping("current")
    public String currentUser(){
        String name= SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        log.info("current user {}",name);
        return "current user :"+name;
    }

}
