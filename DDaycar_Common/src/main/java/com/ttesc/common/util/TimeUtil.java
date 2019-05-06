package com.ttesc.common.util;

import sun.nio.ch.SelectorImpl;

import java.net.CacheRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2019/4/30 15:31
 */
public class TimeUtil {
    public static String getTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    //当前时间 加上或减去指定天数
    public static Date add(int days){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,days);
        return calendar.getTime();
    }
}
