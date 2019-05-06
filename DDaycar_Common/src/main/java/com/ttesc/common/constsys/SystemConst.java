package com.ttesc.common.constsys;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:30
 */
public class SystemConst {
    //返回码
    public static final int OK=1000;
    public static final int ERROR=1001;

    //短信模板
    public static final String DTMB="SMS_164470243";
    public static final String YZMMB="SMS_114390520";

    //秘钥
    public static final String TOKENKEY="PTeW11QpXc+IKUAcO8e8FA==";


    //积分有效期
    public static final int SCOREEXPIRE=365;

    //积分类型
    public static final int SIGNTYPE=1;//签到
    public static final int REDPACKAGETYPE=2;//红包
    public static final int CJTYPE=3;//抽奖


    //抽奖每轮消耗的积分
    public static final int CJSCORE=10;

    public static final String[] JX=new String[]{"一等奖：法拉利 跑车一辆",
            "二等奖:哈弗H6 一辆","三等奖:大众汽车 购物卷 10000元",
            "四等奖：国产汽车 抵用券 8888元" ,
            "五等奖：t100加油劵" ,
            "六等奖：100积分" ,"七等奖：19积分" ,
            "八等奖：1积分"};



}
