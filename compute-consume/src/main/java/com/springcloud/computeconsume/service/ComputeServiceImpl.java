package com.springcloud.computeconsume.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeServiceImpl implements ComputeService{

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addFallback")
    @Override
    public void add() {
        ResponseEntity<Integer> result = this.restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", Integer.class);
        LOG.info("ribbon 10+20={}", result.getBody());
    }

    private void addFallback(){
        LOG.error("call compute service error");
    }
}
