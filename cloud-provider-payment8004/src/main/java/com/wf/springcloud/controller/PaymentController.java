package com.wf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author wf
 * @create 2020-03-14 21:21
 * @desc
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentWithZK() {
        return "Spring-Cloud-With-Zookeeper:" + serverPort + "\t" + UUID.randomUUID();
    }
}
