package com.ttesc.ddaycar_serveruser.controller;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.service.UserDetailService;
import com.ttesc.entity.user.Userdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:40
 */
@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService detailService;

    @PostMapping("detail/detailupdate.do")
    public ResultVO update(Userdetail userdetail){
        return detailService.updateDetail(userdetail);
    }




}
