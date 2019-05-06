package com.ttesc.common.main;

import com.ttesc.common.constsys.SystemConst;
import com.ttesc.common.util.AliyunSmsUtil;
import com.ttesc.common.util.EncryptionUtil;
import com.ttesc.common.util.RandomUtil;
import com.ttesc.common.util.TokenUtil;

import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2019/4/29 10:06
 */
public class Sms_Main {
    public static void main(String[] args) {
        //功能测试
//        for(int i=1;i<=100000;i++){
//            int code=RandomUtil.createNum(4);
//            if(code<1000 || code>9999){
//                System.out.println(code);
//            }
//        }
//        int code=RandomUtil.createNum(6);
//        System.out.println(AliyunSmsUtil.sendSms("13523413578",code));
//
        //System.out.println(EncryptionUtil.createAESKEY());
        System.out.println(TokenUtil.createToken(1,"dsdsdsd"));
        System.out.println(EncryptionUtil.AESDec(SystemConst.TOKENKEY,"a8pirM0ZXxrbYGGNng52JHbB2g9BcbkmjXel58pYsqjMXqTGH0z+20aOFnSQCR5L/b9O0xEJneTyOcQuGFbrtxMAHyThWjxjuF+T90JdNF3xqtqqfQaEOsQwFuLcYoZn"));
    }
}
