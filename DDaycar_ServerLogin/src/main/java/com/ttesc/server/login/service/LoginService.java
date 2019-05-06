package com.ttesc.server.login.service;

import com.ttesc.common.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2019/4/29 14:42
 */
public interface LoginService {
    ResultVO login(String phone, String password, HttpServletResponse response);
    ResultVO checkLogin(HttpServletRequest request);
    ResultVO exit(HttpServletRequest request,HttpServletResponse response);
}
