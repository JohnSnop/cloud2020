package com.wf.springcloud.service;

import com.wf.springcloud.entities.CommonResult;
import com.wf.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wf
 * @create 2020-04-01 21:55
 * @desc
 **/
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSql/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") String id);

}
