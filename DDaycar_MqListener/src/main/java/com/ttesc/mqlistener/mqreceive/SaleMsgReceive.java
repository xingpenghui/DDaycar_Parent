package com.ttesc.mqlistener.mqreceive;

import com.alibaba.fastjson.JSON;
import com.ttesc.common.constsys.SystemConst;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.sale.Saleuser;
import com.ttesc.entity.user.User;
import com.ttesc.mqlistener.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@Author feri
 *@Date Created in 2019/5/10 15:56
 */
@Component
@RabbitListener(queues ="ddaycar_saleuser")
public class SaleMsgReceive {
    @Autowired
    private UserService userService;
    @RabbitHandler
    public void process(String msg){
        System.out.println("消费者："+msg);
        Saleuser saleuser= JSON.parseObject(msg,Saleuser.class);
        //1、校验是否为会员
        ResultVO resultVO=userService.checkPhone(saleuser.getPhone());
        if(resultVO.getCode()==SystemConst.OK) {
            //2、不是会员，新增为会员
            User user = new User();
            user.setPhone(saleuser.getPhone());
            user.setPassword(saleuser.getPhone().substring(saleuser.getPhone().length() - 6));
            userService.save(user);
        }
//

    }
}
