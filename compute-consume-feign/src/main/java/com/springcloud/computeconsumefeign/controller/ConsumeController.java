package com.springcloud.computeconsumefeign.controller;

import com.springcloud.computeconsumefeign.remote.ComputeClient;
import com.springcloud.computeconsumefeign.remote.ComputeClient2;
import com.springcloud.computeconsumefeign.remote.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private ComputeClient computeClient;

    @Autowired
    private ComputeClient2 computeClient2;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add(){
        Integer result = this.computeClient.add(10, 20);

        LOG.info("feign client 10+20={}", result);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void sayHello(){
        User user = new User();
        user.setName("world");
        user.setAge(100);
        String msg = this.computeClient.sayHello(user);

        LOG.info("feign client hello = {}", msg);
    }

    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public void add2(){
        Integer result = this.computeClient2.add(10, 20);

        LOG.info("feign client 2 10+20={}", result);
    }

}
