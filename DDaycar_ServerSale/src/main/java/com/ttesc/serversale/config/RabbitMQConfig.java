package com.ttesc.serversale.config;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/5/10 15:33
 */
@Configuration
public class RabbitMQConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private int port;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;

    //存储预约用户的信息 队列名称
    public static final String queueName="ddaycar_saleuser";
    public static final String fanoutName="ddatcar_sale_exchange";

    @Bean
    public RabbitTemplate rabbitTemplate(){
        CachingConnectionFactory factory=new CachingConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setPublisherConfirms(true);//设置 需要应答
        RabbitTemplate rabbitTemplate=new RabbitTemplate(factory);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("消息提供者"+correlationData.toString());
                //调用了 消息消费了
            }
        });
        return rabbitTemplate;
    }

    //DirectExchange
   // TopicExchange
    //HeadersExchange
    //FanoutExchange
    //定义交换器
    @Bean
    public FanoutExchange createFE(){
        return new FanoutExchange(fanoutName);
    }
    //定义队列
    @Bean
    public Queue createQueue(){
        return new Queue(queueName);
    }
    //交换器绑定队列
    @Bean
    public Binding createBild(Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
