package com.wf.springcloud.service;

import com.wf.springcloud.entities.CommonResult;
import com.wf.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author wf
 * @create 2020-04-01 21:59
 * @desc
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSql(String id) {
        return new CommonResult<>(444, "服务降级，PaymentFallbackService");
    }
}
