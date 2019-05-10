package com.ttesc.task.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *@Author feri
 *@Date Created in 2019/5/10 16:27
 */
@Component
public class SaleJob {

    @Scheduled(cron = "0 0 22 * * ?")
    public void job(){
        System.out.println("执行MQ 的消息最终一致性");
    }
}
