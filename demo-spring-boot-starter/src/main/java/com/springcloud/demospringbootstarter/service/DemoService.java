package com.springcloud.demospringbootstarter.service;

public class DemoService {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String sayHello(){
        return "hello " + this.name;
    }

}
