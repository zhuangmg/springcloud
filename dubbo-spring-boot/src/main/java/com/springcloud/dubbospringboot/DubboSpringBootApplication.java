package com.springcloud.dubbospringboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDubboConfiguration
@SpringBootApplication
public class DubboSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSpringBootApplication.class, args);

        try{
            //System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
