package com.wf.springcloud.service;

import com.wf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author wf
 * @create 2020-03-13 21:03
 * @desc
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
