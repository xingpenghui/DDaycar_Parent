package com.ttesc.ddaycar_serverbuy.controller;

import com.ttesc.ddaycar_serverbuy.service.BuySubFollowService;
import com.ttesc.entity.buy.Buysubfollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/5/10 11:32
 */
@RestController
public class BuySubFollowController {
    @Autowired
    private BuySubFollowService buySubFollowService;

    @GetMapping("/buy/single.do")
    public Buysubfollow single(int id){
        return buySubFollowService.getById(id);
    }

}
