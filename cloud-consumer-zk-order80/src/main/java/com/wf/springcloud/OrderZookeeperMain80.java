package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wf
 * @create 2020-03-15 13:04
 * @desc
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZookeeperMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZookeeperMain80.class, args);
    }
}
