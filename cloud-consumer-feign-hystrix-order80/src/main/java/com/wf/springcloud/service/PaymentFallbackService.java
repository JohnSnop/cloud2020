package com.wf.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wf
 * @create 2020-03-18 20:19
 * @desc
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--PaymentFallbackService--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--PaymentFallbackService--paymentInfo_TimeOut";
    }
}

