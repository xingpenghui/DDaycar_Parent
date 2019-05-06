package com.ttesc.esapi.config;

import com.ttesc.esapi.util.TransportUtil;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 *@Author feri
 *@Date Created in 2019/5/6 14:35
 */
@Configuration
public class TransportConfig {
//    @Bean
//    public Client createClient(){
//        Settings settings=Settings.builder().put("cluster.name","qfjava").build();
//        Client client=new PreBuiltTransportClient(settings).addTransportAddress(
//                new TransportAddress(new InetSocketAddress("39.105.189.141",9300))
//        );
//        return client;
//    }
    @Bean
    public TransportUtil createTU(){
        return new TransportUtil("qfjava","39.105.189.141",9300);
    }
}
