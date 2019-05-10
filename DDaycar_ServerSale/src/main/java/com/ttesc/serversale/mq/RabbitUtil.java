package com.ttesc.serversale.mq;

import com.ttesc.serversale.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@Author feri
 *@Date Created in 2019/5/10 15:43
 */
@Component
public class RabbitUtil {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发送消息
    public void sendMsg(int id,String msg){
        CorrelationData correlationData=new CorrelationData(id+"");
        rabbitTemplate.convertAndSend("",RabbitMQConfig.queueName,msg,correlationData);
    }
    //发送消息
    public void sendMsgExchange(String exchange,String qname,int id,String msg){
        CorrelationData correlationData=new CorrelationData(id+"");
        rabbitTemplate.convertAndSend(exchange,qname,msg,correlationData);
    }

}
