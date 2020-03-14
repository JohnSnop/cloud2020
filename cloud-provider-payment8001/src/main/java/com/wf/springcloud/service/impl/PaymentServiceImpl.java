package com.wf.springcloud.service.impl;

import com.wf.springcloud.dao.PaymentDao;
import com.wf.springcloud.entities.Payment;
import com.wf.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-03-13 21:04
 * @desc
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

//    @Autowired
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
