package com.ttesc.server.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.ttesc.common.util.JedisUtil;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.util.TokenUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.common.vo.TokenVO;
import com.ttesc.entity.user.User;
import com.ttesc.server.login.dao.LoginDao;
import com.ttesc.server.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2019/4/29 14:44
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public ResultVO login(String phone, String password, HttpServletResponse response) {
        //1、查询
        User user=loginDao.login(phone);
        if(user!=null){
            //2、校验密码
            if(user.getPassword().equals(password)){
                //3、登录成功
                //1、生成Token
                String token=TokenUtil.createToken(user.getId(),phone);
                //2、存储到Redis
                //记录Token有效期30分钟
                jedisUtil.setStr("user:"+phone,token,1800);
                //记录当前登录用户的详细信息
                jedisUtil.setStr(token,JSON.toJSONString(user),1800);
                //3、存储到Cookie
                Cookie cookie=new Cookie("usertoken",token);
                cookie.setPath("/");
                response.addCookie(cookie);
                return ResultUtil.exec(true,"登录成功",token);
                //cookie.setDomain("");
            }
        }
        return ResultUtil.exec(false,"用户名或密码不正确",null);
    }

    @Override
    public ResultVO checkLogin(HttpServletRequest request) {
        Cookie[] arr=request.getCookies();
        String token="";
        for(Cookie c:arr){
            if(c.getName().equals("usertoken")){
                token=c.getValue();
                break;
            }
        }
        if(token.length()>0){
            //token存在
            if(jedisUtil.isExists(token)){
                //有效
                String json=jedisUtil.getStr(token);
                User user=JSON.parseObject(json,User.class);
                return ResultUtil.exec(true,"已经登录，且有效",user.getPhone());
            }else {
                return  ResultUtil.exec(false,"Token已经失效，请重新登录",null);
            }
        }else {
            return ResultUtil.setERROR();
        }
    }

    @Override
    public ResultVO exit(HttpServletRequest request,HttpServletResponse response) {
        Cookie[] arr=request.getCookies();
        String token="";
        for(Cookie c:arr){
            if(c.getName().equals("usertoken")){
                token=c.getValue();
                break;
            }
        }
        //删除Redis
        jedisUtil.delKey(token);
        TokenVO tokenVO=TokenUtil.parseToken(token);
        jedisUtil.delKey("user:"+tokenVO.getContent());
        //删除Cookie
        Cookie cookie=new Cookie("usertoken","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResultUtil.setOK("注销成功");
    }
}
