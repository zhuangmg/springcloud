package com.springcloud.computeservice.controller;

import com.springcloud.computeservice.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b){
        Integer result = a + b;
        LOG.info("a={},b={}, a+b={}", a, b, result);
        return result;
    }

    @RequestMapping(value="/hello", method = RequestMethod.POST)
    public String sayHello(@RequestBody User user){
        LOG.info("user name={}, age={}", user.getName(), user.getAge());
        return "hello "+ user.getName();
    }

}
