package com.wf.springcloud.controller;

import com.wf.springcloud.entities.CommonResult;
import com.wf.springcloud.entities.Payment;
import com.wf.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer//payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment,
                CommonResult.class);
    }

    @PostMapping("/consumer//payment/createForEntity")
    public CommonResult<Payment> createForEntity(@RequestBody Payment payment) {

        return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment,
                CommonResult.class).getBody();
    }

    @GetMapping("/consumer//payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer//payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentForObject(@PathVariable("id") Long id) {
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<Payment>(400, "查询失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0) {
            return "没有可用的服务";
        }

        ServiceInstance instance = loadBalancer.instances(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
