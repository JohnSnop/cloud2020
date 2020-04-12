package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Order;
import com.wf.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-12 15:05
 * @desc
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/order/create")
    public CommonResult create(Order order) {
        orderService.createOrder(order);
        return new CommonResult(200, "订单创建成功");
    }
}
