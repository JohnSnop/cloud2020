package com.wf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-03-15 13:05
 * @desc
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
    public String paymentZK() {
        return restTemplate.getForObject(INVOKE_URL + "//payment/zk", String.class);
    }
}
