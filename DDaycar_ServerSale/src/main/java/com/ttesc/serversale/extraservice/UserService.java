package com.ttesc.serversale.extraservice;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/5/10 14:36
 */
@FeignClient(name = "UserProvider")
public interface UserService {
    @GetMapping("user/checkphone.do")
    ResultVO checkPhone(@RequestParam("phone") String phone);
    @PostMapping("user/register.do")
    ResultVO save(@RequestBody User user);

}
