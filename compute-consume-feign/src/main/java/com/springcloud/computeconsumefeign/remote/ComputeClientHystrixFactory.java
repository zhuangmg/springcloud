package com.springcloud.computeconsumefeign.remote;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ComputeClientHystrixFactory implements FallbackFactory<ComputeClient2> {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public ComputeClient2 create(Throwable throwable) {

        if(throwable.getMessage() != null){
            LOG.error("throwable = {}", throwable.getMessage(), throwable);
        }

        return (Integer a, Integer b) -> {
            LOG.info("a={}, b={}", a, b);
            return -2;
        };
    }
}
