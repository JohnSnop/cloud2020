package com.wf.springcloud.dao;

import com.wf.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wf
 * @create 2020-04-12 14:14
 * @desc
 **/
@Mapper
public interface OrderDao {

    int createOrder(Order order);

    int updateOrderStatus(@Param("userId")Long userId, @Param("status")Integer status);
}
