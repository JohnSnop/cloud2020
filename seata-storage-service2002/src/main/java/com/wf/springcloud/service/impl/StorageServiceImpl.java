package com.wf.springcloud.service.impl;

import com.wf.springcloud.dao.StorageDao;
import com.wf.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-12 16:10
 * @desc
 **/
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}
