package com.ttesc.ddaycar_carapi.service;

import com.ttesc.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/5/10 16:31
 */
@FeignClient(name = "SaleProvider")
public interface SaleUserService {
    @GetMapping("sale/single.do")
    public ResultVO single(@RequestParam("id") int id);
    @PostMapping("sale/adduser.do")
    public ResultVO add(@RequestParam("phone")String phone);
}
