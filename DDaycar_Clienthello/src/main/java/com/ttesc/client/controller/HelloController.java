package com.ttesc.client.controller;

import com.ttesc.client.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/28 11:37
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;
    @GetMapping("client/hello.do")
    public String hi(){
        return helloService.hi();
    }
}
