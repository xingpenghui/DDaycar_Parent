package com.ttesc.ddaycar_serveruser.controller;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.service.UserService;
import com.ttesc.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:38
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("user/register.do")
    public ResultVO save(@RequestBody User user){
        return userService.register(user);
    }
    @GetMapping("user/checkphone.do")
    public ResultVO checkPhone(@RequestParam("phone") String phone){
        return userService.checkPhone(phone);
    }



}
