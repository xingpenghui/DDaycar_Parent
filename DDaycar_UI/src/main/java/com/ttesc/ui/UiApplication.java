package com.ttesc.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *@Author feri
 *@Date Created in 2019/4/30 14:12
 */
@SpringBootApplication
public class UiApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UiApplication.class);
    }
}
