package com.wf.springcloud;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author wf
 * @create 2020-03-21 15:38
 * @desc
 **/
public class Test01 {
    public static void main(String[] args) {
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println(dateTime);

        // 获取指定地区的时间
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);

    }
}
