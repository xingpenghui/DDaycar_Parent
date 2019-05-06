package com.ttesc.ddaycar_serveruser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.user.Usersign;

/**
 *@Author feri
 *@Date Created in 2019/4/30 10:09
 */
public interface UserSignService{

    //签到
    ResultVO sign(int uid);
    //本月的签到记录
    ResultVO queryMonth(int uid);

}
