package com.wf.springcloud;

import com.wf.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author wf
 * @create 2020-03-13 22:24
 * @desc
 **/
@SpringBootApplication
@EnableEurekaClient
/**
 * 经自己粗略测试
 * name = "CLOUD-PAYMENT-SERVICE"
 * 才有随机的效果
 *
 * name = "cloud-payment-service"
 * 随机算法好像是不生效
 */
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)

//@RibbonClient(name = "cloud-payment-service", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
