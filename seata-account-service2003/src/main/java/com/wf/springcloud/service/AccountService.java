package com.wf.springcloud.service;

import java.math.BigDecimal;

/**
 * @author wf
 * @create 2020-04-12 16:34
 * @desc
 **/
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
