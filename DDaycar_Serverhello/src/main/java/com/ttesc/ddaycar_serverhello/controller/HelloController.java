package com.ttesc.ddaycar_serverhello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/28 11:10
 */
@RestController
public class HelloController {
    @GetMapping("hello.do")
    public String hello(){
        return "hello,Word";
    }
}
