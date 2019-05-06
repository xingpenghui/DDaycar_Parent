package com.ttesc.common.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *@Author feri
 *@Date Created in 2019/4/25 10:14
 */
public class JedisUtil {
    private JedisPool jedisPool;
    public JedisUtil(String host,int port,String pass){
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxIdle(300);//空闲时间
        config.setMaxTotal(1000);//最大连接
        config.setMinIdle(100);
        jedisPool=new JedisPool(config,host,port,1000,pass);
    }
    //新增
    public String setStr(String key,String value){
        return jedisPool.getResource().set(key,value);
    }
    public String setStr(String key,String value,int seconds){
        return jedisPool.getResource().setex(key,seconds,value);
    }
    public Long setHash(String key,String field,String value){
        return jedisPool.getResource().hset(key,field,value);
    }
    //删除
    public void delKey(String... keys){
        jedisPool.getResource().del(keys);
    }

    //修改
    //查询
    public String getStr(String key){
        return jedisPool.getResource().get(key);
    }
    //系统
    public void setExpire(String key,int seconds){
        jedisPool.getResource().expire(key,seconds);
    }

    //自增
    public void incre(String key){
        jedisPool.getResource().incr(key);
    }
   public boolean isExists(String key){
        return jedisPool.getResource().exists(key);
   }
}
