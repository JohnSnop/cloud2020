package com.wf.springcloud.service;

/**
 * @author wf
 * @create 2020-04-12 16:09
 * @desc
 **/
public interface StorageService {
    void decrease(Long productId, Integer count);
}
