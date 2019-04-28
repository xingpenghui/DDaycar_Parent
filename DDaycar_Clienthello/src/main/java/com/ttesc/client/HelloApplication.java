package com.ttesc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@Author feri
 *@Date Created in 2019/4/28 11:25
 */
@SpringBootApplication
@EnableEurekaClient   //标记服务客户端
@EnableDiscoveryClient //发现服务
@EnableFeignClients  //启用Feign
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class,args);
    }
}
