package com.ttesc.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/30 14:18
 */
@RestController
public class HelloController {
    @GetMapping("/qfjava")
    public String java(){
        return "Study Java";
    }
}
