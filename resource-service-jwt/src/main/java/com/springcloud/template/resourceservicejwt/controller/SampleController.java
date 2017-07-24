package com.springcloud.template.resourceservicejwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping(path = "/jwt/hello")
    public String helloJwt(){
        return "helloJwt";
    }
}
