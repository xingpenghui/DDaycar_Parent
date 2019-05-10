package com.ttesc.ddaycar_carapi.api;

import com.alibaba.fastjson.JSON;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_carapi.service.SaleUserService;
import com.ttesc.entity.sale.Saleuser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2019/5/10 16:33
 */
@Api(value = "预约卖车",tags = "预约卖车")
@RestController
public class SaleUserController {
    @Autowired
    private SaleUserService saleUserService;

    @ApiOperation(value = "查询单个",notes = "查询单个")
    @GetMapping("sale/single.do")
    public ResultVO single(@RequestParam("id") int id){
        return saleUserService.single(id);
    }
    //预约卖车
    @ApiOperation(value = "新增卖车方式",notes = "新增卖车方式")
    @PostMapping("sale/adduser.do")
    public ResultVO add(@RequestParam("phone")String phone){
        return saleUserService.add(phone);
    }
}
