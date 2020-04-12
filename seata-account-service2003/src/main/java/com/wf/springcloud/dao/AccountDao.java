package com.wf.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wf
 * @create 2020-04-12 16:29
 * @desc
 **/
@Mapper
public interface AccountDao {
    void decrease(@Param("userId")Long userId, @Param("money") BigDecimal money);
}
