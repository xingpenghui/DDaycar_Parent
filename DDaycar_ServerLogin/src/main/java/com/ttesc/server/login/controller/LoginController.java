package com.ttesc.server.login.controller;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.server.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2019/4/29 15:56
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("user/login.do")
    public ResultVO login(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletResponse response){
        return loginService.login(phone,password,response);
    }
    @GetMapping("user/checklogin.do")
    public ResultVO checkLogin(HttpServletRequest request){
        return loginService.checkLogin(request);
    }
    @GetMapping("user/userexit.do")
    public ResultVO exit(HttpServletRequest request,HttpServletResponse response){
        return loginService.exit(request, response);
    }

}
