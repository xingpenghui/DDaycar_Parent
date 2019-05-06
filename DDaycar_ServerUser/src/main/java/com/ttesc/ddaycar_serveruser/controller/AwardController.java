package com.ttesc.ddaycar_serveruser.controller;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/30 15:39
 */
@RestController
public class AwardController {
    @Autowired
    private AwardService awardService;

    @PostMapping("award/creataward.do")
    public ResultVO create(@RequestParam("uid") int uid){
        return awardService.startAward(uid);
    }

}
