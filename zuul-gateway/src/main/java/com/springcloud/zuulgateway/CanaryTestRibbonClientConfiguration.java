package com.springcloud.zuulgateway;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CanaryTestRibbonClientConfiguration {
    @LocalServerPort
    private  int port;

    private static Server testCanaryInstance;

    @Bean
    public ServerList<Server> ribbonServerList() {
        return new StaticServerList<>(new Server("normal-routing-notexist-localhost", this.port));
    }

    @Bean
    public IRule canaryTestRule() {
        if (testCanaryInstance == null) {
            testCanaryInstance = new Server("localhost", port); // use test server as a canary instance
        }
        return new TestCanaryRule();
    }

    public static class TestCanaryRule extends AvailabilityFilteringRule {
        @Override
        public Server choose(Object key) {
            if ((key != null) && (key.equals("canary"))) {
                return testCanaryInstance;  // choose test canary server instead of normal servers.
            }
            return super.choose(key); // normal routing
        }
    }
}
