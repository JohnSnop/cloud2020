package com.wf.springcloud.controller;

import com.wf.springcloud.entities.CommonResult;
import com.wf.springcloud.entities.Payment;
import com.wf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wf
 * @create 2020-03-13 21:08
 * @desc
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果======{}", result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(400, "插入数据失败", null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果======{}", paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功", paymentById);
        } else {
            return new CommonResult(400, "查询失败", null);
        }
    }
}
