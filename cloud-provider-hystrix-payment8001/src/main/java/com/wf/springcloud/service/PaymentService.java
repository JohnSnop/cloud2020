package com.wf.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wf
 * @create 2020-03-17 20:30
 * @desc
 **/
public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
