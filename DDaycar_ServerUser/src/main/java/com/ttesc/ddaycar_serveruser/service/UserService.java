package com.ttesc.ddaycar_serveruser.service;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.user.User;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:27
 */
public interface UserService {
    ResultVO register(User user);
    ResultVO checkPhone(String phone);
}
