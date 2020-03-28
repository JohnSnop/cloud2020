package com.wf.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wf
 * @create 2020-03-28 17:08
 * @desc
 **/
@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String getA() {
        return "Test--A";
    }

    @GetMapping("/testB")
    public String getB() {
        return "Test--B";
    }
}
