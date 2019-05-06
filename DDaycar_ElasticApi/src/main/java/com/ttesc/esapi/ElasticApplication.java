package com.ttesc.esapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@Author feri
 *@Date Created in 2019/5/6 10:20
 */
@SpringBootApplication
@EnableSwagger2

public class ElasticApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticApplication.class,args);
    }
}
