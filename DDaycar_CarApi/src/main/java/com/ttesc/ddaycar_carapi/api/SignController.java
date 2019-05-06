package com.ttesc.ddaycar_carapi.api;

import com.ttesc.common.util.TokenUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_carapi.service.SignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:28
 */
@Api(value = "签到相关操作",tags = "签到操作")
@RestController
public class SignController {
    @Autowired
    private SignService signService;
    //签到
    @ApiOperation(value = "签到",notes = "实现用户的签到")
    @PostMapping("sign/signsave.do")
    public ResultVO sign(@ApiParam(value = "用户登录令牌")String token){
        return signService.sign(TokenUtil.parseToken(token).getUid());
    }
    //查询近30天的签到数据
    @GetMapping("sign/signdays.do")
    @ApiOperation(value = "近30天的签到数据",notes = "近30天的签到数据")
    public ResultVO days(@ApiParam(value = "用户登录令牌") String token){
        return signService.days(TokenUtil.parseToken(token).getUid());
    }
}
