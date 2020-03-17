package com.wf.springcloud.service;

/**
 * @author wf
 * @create 2020-03-17 20:30
 * @desc
 **/
public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);
}
