package com.ttesc.server.login.config;

import com.ttesc.common.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/5/6 09:58
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisUtil createJU(){
        return new JedisUtil("39.105.189.141",6379,"qfjava");
    }
}
