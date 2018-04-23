package com.springcloud.computeconsumefeign.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ComputeClientHystrix implements ComputeClient{

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public Integer add(Integer a, Integer b) {
        LOG.error("call hystrix....");
        return -1;
    }
}
