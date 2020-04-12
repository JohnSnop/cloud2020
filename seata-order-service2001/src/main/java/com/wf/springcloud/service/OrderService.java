package com.wf.springcloud.service;

import com.wf.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author wf
 * @create 2020-04-12 14:35
 * @desc
 **/
public interface OrderService {
    Order createOrder(Order order);

}
