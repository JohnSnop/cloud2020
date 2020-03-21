package com.wf.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-03-21 14:52
 * @desc
 **/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes = builder.routes();
        // http://news.baidu.com/guonei
        routes.route("path_route_simple1", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route_simple2", r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }
}
