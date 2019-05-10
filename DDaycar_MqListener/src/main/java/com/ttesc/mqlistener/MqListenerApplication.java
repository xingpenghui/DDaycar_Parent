package com.ttesc.mqlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@Author feri
 *@Date Created in 2019/5/10 15:55
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class MqListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqListenerApplication.class,args);
    }
}
