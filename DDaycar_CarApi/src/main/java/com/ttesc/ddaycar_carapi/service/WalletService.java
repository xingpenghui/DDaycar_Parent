package com.ttesc.ddaycar_carapi.service;

import com.ttesc.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:52
 */
@FeignClient(name = "UserProvider")
public interface WalletService {
    @PostMapping("wallet/walletscore.do")
    ResultVO update(@RequestParam("uid")int uid, @RequestParam("score")int score);
    @PostMapping("wallet/walletlosescore.do")
    ResultVO updatelose(@RequestParam("uid")int uid,@RequestParam("score")int score);

}
