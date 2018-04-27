package com.springcloud.zuulgateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableAutoConfiguration
@RestController
//@SpringBootApplication
@EnableZuulProxy
//@EnableDiscoveryClient
@RibbonClient(name = "simple", configuration = CanaryTestRibbonClientConfiguration.class)
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "canary";
    }

    @Bean
    public ZuulFilter testCanarySupportPreFilter() {
        return new ZuulFilter() {
            @Override
            public String filterType() {
                return FilterConstants.PRE_TYPE;
            }

            @Override
            public int filterOrder() {
                return 0;
            }

            @Override
            public boolean shouldFilter() {
                return true;
            }

            @Override
            public Object run() {
                RequestContext context = RequestContext.getCurrentContext();
                if (checkIfCanaryRequest(context)) {
                    context.set(FilterConstants.LOAD_BALANCER_KEY, "canary");
                }
                return null;
            }

            private boolean checkIfCanaryRequest(RequestContext context) {
                HttpServletRequest request = context.getRequest();
                String canaryHeader = request.getHeader("X-Canary-Test");
                if ((canaryHeader != null) && (canaryHeader.equalsIgnoreCase("true"))) {
                    return true;
                }
                return false;
            }
        };
    }
}
