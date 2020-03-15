package com.wf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author wf
 * @create 2020-03-15 14:40
 * @desc
 **/
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentWithConsul() {
        return "Spring-Cloud-With-Consul:" + serverPort + "\t" + UUID.randomUUID();
    }
}
