package com.springcloud.dubbospringboot.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.demo.DemoService;
import org.springframework.stereotype.Service;

@Service
public class HelloConsumer {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private DemoService demoService;

    public String sayHello(){
        return this.demoService.sayHello("hello");
    }
}
