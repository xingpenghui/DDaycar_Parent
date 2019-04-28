package com.ttesc.ddaycar_carapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient //发现服务
@EnableFeignClients //启用Feign
@EnableSwagger2 //启用Swagger
public class DdaycarCarapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdaycarCarapiApplication.class, args);
    }

}
