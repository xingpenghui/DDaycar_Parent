package com.ttesc.ddaycar_serverhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //标记这是一个客户端

public class DdaycarServerhelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdaycarServerhelloApplication.class, args);
    }

}
