package com.springcloud.demospringbootstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DemoService.class)
@EnableConfigurationProperties(DemoServiceProperties.class)
public class DemoAutoConfigure {

    @Autowired
    private DemoServiceProperties demoServiceProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "demo.springcloud", value = "enabled", havingValue = "true")
    DemoService demoService(){
        DemoService demoService = new DemoService();
        demoService.setName(this.demoServiceProperties.getName());
        return demoService;
    }
}
