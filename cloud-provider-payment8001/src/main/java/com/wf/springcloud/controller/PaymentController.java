package com.wf.springcloud.controller;

import com.wf.springcloud.entities.CommonResult;
import com.wf.springcloud.entities.Payment;
import com.wf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果======{},======端口号{}", result, serverPort);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功，端口号" + serverPort, result);
        } else {
            return new CommonResult(400, "插入数据失败", null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果======{}", paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功，端口号" + serverPort, paymentById);
        } else {
            return new CommonResult(400, "查询失败", null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务============{}", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances) {
            log.info("id=={},host=={},==port{}", instance.getInstanceId(), instance.getHost(), instance.getPort());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
