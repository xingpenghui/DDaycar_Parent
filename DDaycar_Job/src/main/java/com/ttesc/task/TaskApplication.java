package com.ttesc.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *@Author feri
 *@Date Created in 2019/5/6 15:35
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.ttesc.task.mpper")
public class TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class,args);
    }
}