package com.wf.springcloud.dao;

import com.wf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wf
 * @create 2020-03-13 20:41
 * @desc
 **/
@Mapper
public interface PaymentDao {
     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}
