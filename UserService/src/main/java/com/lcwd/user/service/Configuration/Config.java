package com.lcwd.user.service.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    @LoadBalanced  //  the process of distributing incoming network traffic across multiple instances of an application. This helps to ensure that no single instance is overwhelmed with too much traffic
    // Also it allows to replace the localhost and port with Application name present on eureka server on which these services are registered.
    // As , now we need not have to worry as and when we change the host and change port , as the application name registered in the eureka server won't change.
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
