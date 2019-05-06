package com.ttesc.ddaycar_carapi.service;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:51
 */
@FeignClient(name = "UserProvider")
public interface UserSrvice {
    @PostMapping("user/register.do")
    ResultVO save(@RequestBody User user);
    @GetMapping("user/checkphone.do")
    ResultVO checkPhone(@RequestParam("phone")String phone);


}
