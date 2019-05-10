package com.ttesc.ddaycar_serveruser.dao;

import com.ttesc.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:26
 */
public interface UserDao {
    @Insert("insert into user(phone,password,flag) values(#{phone},#{password},1)")
    @Options(useGeneratedKeys = true,keyProperty = "id")//获取自增主键的值
    int save(User user);
    @Select("select id,phone,password,flag from user where phone=#{phone}")
    User selectByPhone(String phone);
}