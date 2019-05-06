package com.ttesc.ddaycar_carapi.api;

import com.ttesc.common.util.AliyunSmsUtil;
import com.ttesc.common.util.RandomUtil;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_carapi.core.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/29 10:17
 */
@Api(value = "短信操作",tags = "sms短信操作")
@RestController
public class SmsController {
    @Autowired
    private CodeService codeService;
    //发送验证码  一份钟发送1次  验证码3分钟失效
    @ApiOperation(value = "发送短信验证码",notes = "发送短信验证码")
    @PostMapping("sms/sendmsg.do")
    public ResultVO sendMsg(String phone){
        return codeService.sendReMsg(phone);
    }
    //
    @ApiOperation(value = "校验短信验证码",notes = "校验短信验证码")
    @GetMapping("sms/checkcode.do")
    public ResultVO checkCode(String phone,String code){
        return codeService.checkCode(phone,code);
    }
}
