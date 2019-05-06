package com.ttesc.ddaycar_serveruser.service;

import com.ttesc.common.vo.ResultVO;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:40
 */
public interface UserWalletService {
    ResultVO updateTotalScore(int uid,int tscore);
    ResultVO updateLoseScore(int uid,int lscore);
    ResultVO queryByUid(int uid);
}
