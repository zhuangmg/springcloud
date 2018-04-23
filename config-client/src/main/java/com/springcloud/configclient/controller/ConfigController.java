package com.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

    @Value("${port}")
    private String port;

    @Value("${name}")
    private String name;

    @Value("${test}")
    private String test;

    @RequestMapping("/hello")
    public String hello(){

        return this.port + " " + this.name + " " + this.test;
    }

}
