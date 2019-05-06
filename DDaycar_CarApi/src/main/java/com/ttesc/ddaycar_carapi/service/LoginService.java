package com.ttesc.ddaycar_carapi.service;

import com.ttesc.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2019/4/29 16:03
 */
@FeignClient(name = "LoginProvider")
public interface LoginService {
    @PostMapping("user/login.do")
    ResultVO login(@RequestParam("phone") String phone, @RequestParam("password") String password,HttpServletResponse response);
    @GetMapping("user/checklogin.do")
    ResultVO checkLogin(HttpServletRequest request);
    @GetMapping("user/userexit.do")
    ResultVO exit();
}
