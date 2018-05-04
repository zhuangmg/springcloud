package com.springcloud.demospringbootstarter.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("demo.springcloud")
public class DemoServiceProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
