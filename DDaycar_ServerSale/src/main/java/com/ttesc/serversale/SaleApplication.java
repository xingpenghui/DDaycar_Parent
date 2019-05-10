package com.ttesc.serversale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@Author feri
 *@Date Created in 2019/5/10 11:35
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.ttesc.serversale.mapper")
public class SaleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaleApplication.class,args);
    }
}