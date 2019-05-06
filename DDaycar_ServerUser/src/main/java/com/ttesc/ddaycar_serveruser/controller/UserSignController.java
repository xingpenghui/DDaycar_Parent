package com.ttesc.ddaycar_serveruser.controller;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:24
 */
@RestController
public class UserSignController {
    @Autowired
    private UserSignService signService;
    //签到
    @PostMapping("sign/signsave.do")
    public ResultVO sign(@RequestParam("uid") int uid){
        return signService.sign(uid);
    }
    //查询近30天的签到数据
    @GetMapping("sign/signdays.do")
    public ResultVO days(@RequestParam("uid") int uid){
        return signService.queryMonth(uid);
    }


}
