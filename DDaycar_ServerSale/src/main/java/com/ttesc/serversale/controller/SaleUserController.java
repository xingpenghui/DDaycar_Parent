package com.ttesc.serversale.controller;

import com.alibaba.fastjson.JSON;
import com.ttesc.common.constsys.SystemConst;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.sale.Saleuser;
import com.ttesc.entity.user.User;
import com.ttesc.serversale.extraservice.UserService;
import com.ttesc.serversale.mq.RabbitUtil;
import com.ttesc.serversale.service.SaleuserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2019/5/10 11:44
 */
@RestController
public class SaleUserController {

    @Autowired
    private SaleuserService saleuserService;
    @Autowired
    private UserService userService;
   @Autowired
   private RabbitUtil rabbitUtil;

    @GetMapping("sale/single.do")
    public ResultVO single(@RequestParam("id") int id){
        return ResultUtil.exec(true,"OK",saleuserService.getById(id));
    }
    //预约卖车
    @PostMapping("sale/adduser.do")
    public ResultVO add(@RequestParam("phone")String phone){
//        //1、校验是否为会员
//        ResultVO resultVO=userService.checkPhone(phone);
//        if(resultVO.getCode()==SystemConst.OK){
//            //2、不是会员，新增为会员
//            User user=new User();
//            user.setPhone(phone);
//            user.setPassword(phone.substring(phone.length()-6));
//            userService.save(user);
//        }
        //3、添加预约卖车信息
        Saleuser saleuser=new Saleuser();
        saleuser.setPhone(phone);
        saleuser.setCreatetime(new Date());
        saleuser.setFlag(1);
        saleuserService.save(saleuser);
        //异步发送消息
        rabbitUtil.sendMsg(saleuser.getId(),JSON.toJSONString(saleuser));

        return ResultUtil.exec(true,"OK",null);

    }
}