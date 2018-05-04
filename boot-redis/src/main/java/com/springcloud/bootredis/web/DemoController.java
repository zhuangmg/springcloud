package com.springcloud.bootredis.web;

import com.springcloud.demospringbootstarter.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private DemoService demoService;

    @GetMapping("/demostarter")
    public String hello(){
        String msg = this.demoService.sayHello();

        LOG.info("msg :" +  msg);
        return msg;
    }
}
