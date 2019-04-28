package com.ttesc.ddaycar_carapi.api;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_carapi.service.UserSrvice;
import com.ttesc.entity.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:52
 */
@RestController
@Api(value = "用户相关操作",tags = "操作用户")
public class UserController {
    @Autowired
    private UserSrvice userSrvice;
    @CrossOrigin//实现跨域
    @ApiOperation(value = "注册用户",notes = "实现用户的新增")
    @PostMapping("user/usersave.do")
    public ResultVO save(@ApiParam(name = "user",value = "用户相关的键值对") User user){
        return userSrvice.save(user);
    }
}
