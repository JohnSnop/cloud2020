package com.wf.springcloud.service.impl;

import com.wf.springcloud.dao.OrderDao;
import com.wf.springcloud.domain.Order;
import com.wf.springcloud.service.AccountService;
import com.wf.springcloud.service.OrderService;
import com.wf.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-12 14:36
 * @desc
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;


    @Override
    @GlobalTransactional(name = "OrderServiceImpl.createOrder", rollbackFor = Exception.class)
    public Order createOrder(Order order) {
        log.info("=======开始订单处理");
        orderDao.createOrder(order);

        log.info("=======开始--扣减库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("=======完成--扣减库存");

        log.info("=======开始--扣减账户");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("=======完成--扣减账户");

        orderDao.updateOrderStatus(order.getUserId(), 0);
        return order;
    }
}
