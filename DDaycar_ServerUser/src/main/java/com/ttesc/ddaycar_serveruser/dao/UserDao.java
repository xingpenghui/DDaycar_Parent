package com.ttesc.ddaycar_serveruser.dao;

import com.ttesc.entity.user.User;
import org.apache.ibatis.annotations.Insert;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:26
 */
public interface UserDao {
    @Insert("insert into user(phone,password,flag) values(#{phone},#{password},1)")
    int save(User user);
}
