package com.wf.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wf
 * @create 2020-03-13 22:32
 * @desc
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
