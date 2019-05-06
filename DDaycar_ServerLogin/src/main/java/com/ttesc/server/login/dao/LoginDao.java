package com.ttesc.server.login.dao;

import com.ttesc.entity.user.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 *@Author feri
 *@Date Created in 2019/4/29 14:41
 */
public interface LoginDao {
    @Select("select * from user where phone=#{phone} and flag=1")
    @ResultType(User.class)
    User login(String phone);
}
