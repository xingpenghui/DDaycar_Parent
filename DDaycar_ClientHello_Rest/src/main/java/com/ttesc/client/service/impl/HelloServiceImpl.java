package com.ttesc.client.service.impl;

import com.ttesc.client.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *@Author feri
 *@Date Created in 2019/4/28 14:26
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String hi() {
        return restTemplate.getForObject("http://HelloProvider/hello.do",String.class);
//        restTemplate.getForObject(); //查询 get
//        restTemplate.postForObject();// post
//        restTemplate.put();// 修改 put
//        restTemplate.delete();// 删除 delete

    }
}
