package com.wf.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-03-15 17:44
 * @desc
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule getIRule() {
        return new RandomRule();
    }
}
