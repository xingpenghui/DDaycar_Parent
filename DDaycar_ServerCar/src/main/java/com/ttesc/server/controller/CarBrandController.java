package com.ttesc.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.car.Carbrand;
import com.ttesc.server.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/5/6 09:41
 */
@RestController
public class CarBrandController {
    @Autowired
    private CarBrandService carBrandService;

    @GetMapping("brand/index.do")
    public ResultVO index(){
        QueryWrapper<Carbrand> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("flag",2);
        return ResultUtil.exec(true,"OK",carBrandService.list(queryWrapper));
    }
}
