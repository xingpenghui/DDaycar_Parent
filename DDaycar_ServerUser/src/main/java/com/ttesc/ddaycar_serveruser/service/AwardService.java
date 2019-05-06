package com.ttesc.ddaycar_serveruser.service;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.user.Userwallet;

/**
 *@Author feri
 *@Date Created in 2019/4/30 14:53
 */
public interface AwardService {
    //查询积分
    ResultVO queryScore(int uid);
    //抽奖
    ResultVO startAward(int uid);

}
