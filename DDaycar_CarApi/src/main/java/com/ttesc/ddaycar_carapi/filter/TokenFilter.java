package com.ttesc.ddaycar_carapi.filter;

import com.alibaba.fastjson.JSON;
import com.ttesc.common.util.JedisUtil;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.util.TokenUtil;
import com.ttesc.common.vo.TokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2019/4/29 17:59
 */
@Component
public class TokenFilter implements Filter {
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        //token参数中
        String token=request.getParameter("token");
        if(token!=null && token.length()>0){
            //校验并更新Token
            //检验Token有效
            if(jedisUtil.isExists("user:"+token)){
                //更新Redis的Token失效时间
                TokenVO tokenVO=TokenUtil.parseToken(token);
                String phone=tokenVO.getContent();
                //更新Token
                String newToken=TokenUtil.updateToken(token);
                //更新用户信息
                jedisUtil.delKey(token);
                jedisUtil.setStr("user:"+phone,token,1800);
                jedisUtil.setStr(newToken,phone,1800);
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                HttpServletResponse response=(HttpServletResponse)servletResponse;
                response.getWriter().write(JSON.toJSONString(ResultUtil.exec(false,"令牌失效",null)));
            }
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        //String token1=request.getHeader("usertoken");
    }

    @Override
    public void destroy() {

    }
}
