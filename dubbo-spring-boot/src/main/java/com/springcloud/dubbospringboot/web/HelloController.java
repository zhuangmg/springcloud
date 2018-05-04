package com.springcloud.dubbospringboot.web;

import com.springcloud.dubbospringboot.service.HelloConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    HelloConsumer helloConsumer;

    @GetMapping("/hello")
    public String sayHello(){

        LOG.info("hello");

        String info = this.helloConsumer.sayHello();

        LOG.info(info);

        return info;
    }

}
