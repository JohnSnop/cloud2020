package com.wf.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-03-17 20:30
 * @desc
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：    " + Thread.currentThread().getName() + "paymentInfo_OK,id=" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int seconds = 5;
        int seconds = 3;
//        int a = 10 /0;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：    " + Thread.currentThread().getName() + "paymentInfo_TimeOut,id=" + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "调用接口超时或者异常，\t" + "\t当前线程池名字，" + Thread.currentThread().getName();
    }

    //====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 触发熔断的失败率
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("********id ， 不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t 调用成功，请求流水号:" + simpleUUID;
    }

    public String paymentCircuitBreaker_Fallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请重试，id===" + id;
    }
}
