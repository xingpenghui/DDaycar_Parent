package com.ttesc.ddaycar_serveruser.controller;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:49
 */
@RestController
public class UserWalletController {
    @Autowired
    private UserWalletService walletService;

    @PostMapping("wallet/walletscore.do")
    public ResultVO update(int uid,int score){
        return walletService.updateTotalScore(uid, score);
    }
    @PostMapping("wallet/walletlosescore.do")
    public ResultVO updatelose(int uid,int score){
        return walletService.updateLoseScore(uid, score);
    }
}
