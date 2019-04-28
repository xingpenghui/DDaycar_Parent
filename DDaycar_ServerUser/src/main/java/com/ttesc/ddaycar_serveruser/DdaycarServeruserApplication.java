package com.ttesc.ddaycar_serveruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.ttesc.ddaycar_serveruser.dao")
@EnableEurekaClient
public class DdaycarServeruserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdaycarServeruserApplication.class, args);
    }

}
