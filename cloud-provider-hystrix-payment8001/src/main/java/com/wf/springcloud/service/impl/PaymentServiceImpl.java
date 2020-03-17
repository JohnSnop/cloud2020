package com.wf.springcloud.service.impl;

import com.wf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

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
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：    " + Thread.currentThread().getName() + "paymentInfo_TimeOut,id=" + id;
    }
}
