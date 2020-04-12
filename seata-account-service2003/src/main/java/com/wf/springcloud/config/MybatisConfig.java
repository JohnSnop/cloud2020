package com.wf.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-04-12 16:39
 * @desc
 **/
@Configuration
@MapperScan({"com.wf.springcloud.domain"})
public class MybatisConfig {
}
