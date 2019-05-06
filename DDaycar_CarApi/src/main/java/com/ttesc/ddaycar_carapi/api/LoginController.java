package com.ttesc.ddaycar_carapi.api;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_carapi.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2019/4/29 16:04
 */
@RestController
@Api(value = "登录相关操作",tags = "登录相关")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "单点登录",notes = "实现单点登录")
    @PostMapping("user/login.do")
    public ResultVO login(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletResponse response){
        return loginService.login(phone,password,response);
    }
    @ApiOperation(value = "校验登录是否有效",notes = "校验登录是否有效")
    @GetMapping("user/checklogin.do")
    public ResultVO checkLogin(HttpServletRequest request){
        return loginService.checkLogin(request);
    }

    @ApiOperation(value = "校验登录是否有效",notes = "校验登录是否有效")
    @GetMapping("user/{version}/checklogin.do")
    public ResultVO checkLogin2(HttpServletRequest request,@PathVariable String version){
        return loginService.checkLogin(request);
    }

    @ApiOperation(value = "注销",notes = "注销")
    @GetMapping("user/userexit.do")
    public ResultVO exit(HttpServletRequest request,HttpServletResponse response){
        return loginService.exit();
    }

}
