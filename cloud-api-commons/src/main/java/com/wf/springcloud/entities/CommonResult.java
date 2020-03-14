package com.wf.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wf
 * @create 2020-03-13 22:28
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //example : 404 not_found
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
