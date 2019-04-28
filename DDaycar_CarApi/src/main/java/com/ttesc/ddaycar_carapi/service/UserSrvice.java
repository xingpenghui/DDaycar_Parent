package com.ttesc.ddaycar_carapi.service;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:51
 */
@FeignClient(name = "UserProvider")
public interface UserSrvice {
    @PostMapping("user/register.do")
    ResultVO save(@RequestParam("user")User user);
}
