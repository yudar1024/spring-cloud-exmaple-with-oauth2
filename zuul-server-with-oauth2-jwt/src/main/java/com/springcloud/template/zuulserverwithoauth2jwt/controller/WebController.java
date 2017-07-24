package com.springcloud.template.zuulserverwithoauth2jwt.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

public class WebController {

    @RequestMapping(method = RequestMethod.GET,path = "/foo")
    public String readFoo() {
        return "read foo " + UUID.randomUUID().toString();
    }

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(method = RequestMethod.POST,path = "/foo")
    public String writeFoo() {
        return "write foo " + UUID.randomUUID().toString();
    }
}
