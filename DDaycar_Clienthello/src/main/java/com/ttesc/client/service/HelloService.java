package com.ttesc.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *@Author feri
 *@Date Created in 2019/4/28 11:34
 */
@FeignClient(name = "HelloProvider",decode404 = true) //标记使用哪一个提供者
public interface HelloService {
    @GetMapping("hello.do")
    String hi();
}
