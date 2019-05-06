package com.ttesc.ddaycar_carapi.api;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_carapi.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/5/6 09:56
 */
@Api(value = "操作车辆",tags = "车辆相关操作")
@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @ApiOperation(value = "主页的热门推荐",notes = "主页的热门推荐")
    @GetMapping("/car/hot.do")
    public ResultVO hot(@RequestParam("type")int type){
        return carService.hot(type);
    }
}
