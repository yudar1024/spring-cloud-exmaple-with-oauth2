package com.springcloud.template.resourceserverjwtfeign.feign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "resource-service-jwt")
public interface ResourceServerJwtClient {

    @RequestMapping(path = "/jwt/hello")
    String helloJwt();
}
