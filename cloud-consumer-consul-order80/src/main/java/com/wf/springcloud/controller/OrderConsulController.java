package com.wf.springcloud.controller;

import com.wf.springcloud.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wf
 * @create 2020-03-15 14:54
 * @desc
 **/
@RestController
@Slf4j
public class OrderConsulController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentConsul() {
        return restTemplate.getForObject(Constant.CONSUL_ORDER_URL + "/payment/consul" , String.class);
    }
}
