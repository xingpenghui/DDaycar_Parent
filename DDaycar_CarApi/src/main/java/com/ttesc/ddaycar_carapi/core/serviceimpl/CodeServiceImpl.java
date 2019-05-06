package com.ttesc.ddaycar_carapi.core.serviceimpl;

import com.ttesc.common.util.AliyunSmsUtil;
import com.ttesc.common.util.JedisUtil;
import com.ttesc.common.util.RandomUtil;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_carapi.core.service.CodeService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2019/4/29 10:49
 */
@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public ResultVO sendMsg(String phone) {
        //先验证之前1分钟内是否发过短信、之前3分钟有没有过验证码
        if(jedisUtil.isExists("register:"+phone)){
            return ResultUtil.setOK("请使用之前的验证码");
        }else {
            int code=RandomUtil.createNum(6);
            //存储验证码到Redis  2个key
            //1个key 用于短信失效  三分钟
            jedisUtil.setStr("register:"+phone,code+"",180);

            //1个key  1分钟只能发送一次
            jedisUtil.setStr("sms:"+phone,"",60);
            return ResultUtil.exec(AliyunSmsUtil.sendSms(phone,code),"短信验证码发送成功",null);
        }
    }

    @Override
    public ResultVO sendReMsg(String phone) {
        //先验证之前1分钟内是否发过短信、之前3分钟有没有过验证码
        if(jedisUtil.isExists("sms:"+phone)) {
            if (jedisUtil.isExists("register:" + phone)) {
                //存在就重新把验证码发送一次
                String code=jedisUtil.getStr("register:" + phone);
                jedisUtil.setExpire("register:" + phone,180);
                return ResultUtil.exec(AliyunSmsUtil.sendSms(phone, Integer.parseInt(code)), "短信验证码发送成功", null);
            } else {
                //不存在 生成验证码
                int code = RandomUtil.createNum(6);
                //存储验证码到Redis  2个key
                //1个key 用于短信失效  三分钟
                jedisUtil.setStr("register:" + phone, code + "", 180);

                //1个key  1分钟只能发送一次
                jedisUtil.setStr("sms:" + phone, "", 60);
                return ResultUtil.exec(AliyunSmsUtil.sendSms(phone, code), "短信验证码发送成功", null);
            }
        }else {
            return ResultUtil.setOK("请稍后再试");
        }
    }

    @Override
    public ResultVO checkCode(String phone, String code) {
        String servercode=jedisUtil.getStr("register:"+phone);
       if(Objects.equals(code,servercode)){
           //验证通过
           return ResultUtil.setOK();
       }else {
           return ResultUtil.setERROR();
       }
    }
}
