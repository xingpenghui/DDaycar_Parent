package com.ttesc.task.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.task.core.SystemConst;
import com.ttesc.task.model.LastBean;
import com.ttesc.task.mpper.CarMapper;
import com.ttesc.task.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *@Author feri
 *@Date Created in 2019/5/6 15:38
 */
@Component
public class CarElasticJob {

    @Autowired
    private CarMapper carMapper;
    //实现二手车 车辆快速搜索的数据同步 Mysql----Elasticsearch
    @Scheduled(cron = "0 10 8-20 ? * 2-6")
    public void synchrodata(){
        //数据同步
        //1、获取最后一次的同步时间
        Map<String,Object> param1=new HashMap<>();
        param1.put("index",SystemConst.CARINDEX2);
        param1.put("type","sync");
        param1.put("id",1);
        String last=HttpUtil.getStr("http://localhost:9099/elastic/single.do",param1);
        String lastTime="";
        //2、查询从上一次同步之后的数据
        List<Map<String,Object>> list;
        if(last!=null && last.length()>0){
            ResultVO resultVO= JSON.parseObject(last,ResultVO.class);
            LastBean lastBean=JSON.parseObject(resultVO.getData().toString(),LastBean.class);
           lastTime=lastBean.getTime();
            list=carMapper.queryLast(lastTime);
        }else {
            list=carMapper.queryAll();
        }

        //3、将需要新增的数据传递给ES
        List<Map<String,Object>> tarList=new ArrayList<>();
        for(Map<String,Object> m:list){
            Map<String,Object> map=new HashMap<>();
            map.put("index",SystemConst.CARINDEX1);
            map.put("type","car");
            map.put("id",m.get("id"));
            map.put("content","{\"id\":"+m.get("id")+",\"name\""+m.get("name")+"}");
            tarList.add(map);
        }
        String result=HttpUtil.postJson("http://localhost:9099/elastic/savebatch.do",JSON.toJSONString(tarList));
        //4、校验本次同步是否成功
        ResultVO resultVO=JSON.parseObject(result,ResultVO.class);
        if(resultVO.getCode()==1000){
            //5、成功之后，需要修改最后一次的同步时间
            Map<String,Object> lastMap=new HashMap<>();
            lastMap.put("index",SystemConst.CARINDEX2);
            lastMap.put("type","sync");
            lastMap.put("id","1");
            LastBean lb=new LastBean();
            lb.setId(1);
            lb.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            lastMap.put("content",JSON.toJSONString(lb));
            HttpUtil.postJson("http://localhost:9099/elastic/save.do",JSON.toJSONString(lastMap));
        }


    }
}
