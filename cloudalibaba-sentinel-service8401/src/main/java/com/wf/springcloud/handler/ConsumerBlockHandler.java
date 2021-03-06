package com.wf.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wf.springcloud.entities.CommonResult;

/**
 * @author wf
 * @create 2020-03-29 21:05
 * @desc
 **/
public class ConsumerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(400, "服务不可用handlerException");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(400, "服务不可用handlerException2");
    }
}
