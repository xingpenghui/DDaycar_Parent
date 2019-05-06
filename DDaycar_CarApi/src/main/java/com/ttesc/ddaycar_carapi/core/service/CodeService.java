package com.ttesc.ddaycar_carapi.core.service;

import com.ttesc.common.vo.ResultVO;

/**
 *@Author feri
 *@Date Created in 2019/4/29 10:48
 */
public interface CodeService {
    //发送
    ResultVO sendMsg(String phone);
    //重复发送  验证码不变
    ResultVO sendReMsg(String phone);
    //校验
    ResultVO checkCode(String phone,String code);

}
