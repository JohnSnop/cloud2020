package com.wf.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-03-16 19:46
 * @desc
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level getLevel() {
        return Logger.Level.FULL;
    }
}
