package com.springcloud.bootredis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    //@Autowired
    //private StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public void hello(){
        LOG.info("hello world");

        redisTemplate.opsForValue().set("test2","test2");

        System.out.println(redisTemplate.opsForValue().get("test2"));

        System.out.println(redisTemplate.opsForValue().get("hello"));

        System.out.println(redisTemplate.opsForHash().hasKey("f1", "1111"));

        redisTemplate.opsForHash().put("f1","1111","1.2");

        System.out.println(redisTemplate.opsForHash().entries("f1"));

    }
}
