package com.springcloud.sluethzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SluethZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SluethZipkinApplication.class, args);
    }

}
