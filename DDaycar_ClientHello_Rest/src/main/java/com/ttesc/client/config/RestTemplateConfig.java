package com.ttesc.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *@Author feri
 *@Date Created in 2019/4/28 14:31
 */
@Configuration  //配置
public class RestTemplateConfig {
    @Bean  //修饰方法 目的IOC调用该方法
    @LoadBalanced// Ribbon负载均衡 启用负载均衡
    public RestTemplate createRT(){
        return new RestTemplate();
    }
}
