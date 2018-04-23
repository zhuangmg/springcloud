package com.springcloud.computeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b){
        Integer result = a + b;
        LOG.info("a={},b={}, a+b={}", a, b, result);
        return result;
    }

}
