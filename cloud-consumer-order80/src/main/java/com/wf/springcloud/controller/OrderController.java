package com.wf.springcloud.controller;

import com.wf.springcloud.entities.CommonResult;
import com.wf.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author wf
 * @create 2020-03-13 22:28
 * @desc
 **/
@RestController
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer//payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment,
                CommonResult.class);
    }

    @GetMapping("/consumer//payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
