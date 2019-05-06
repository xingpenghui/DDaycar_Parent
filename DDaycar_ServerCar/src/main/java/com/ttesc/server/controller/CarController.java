package com.ttesc.server.controller;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.server.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/5/6 09:35
 */
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/car/hot.do")
    public ResultVO hot(@RequestParam("type")int type){
        return carService.queryHot();
    }
}
