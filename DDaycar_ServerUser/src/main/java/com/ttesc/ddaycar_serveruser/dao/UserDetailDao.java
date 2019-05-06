package com.ttesc.ddaycar_serveruser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttesc.entity.user.Userdetail;
import org.apache.ibatis.annotations.Insert;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:36
 */
public interface UserDetailDao extends BaseMapper<Userdetail> {

    @Insert("insert into userdetail(uid) values(#{uid})")
    int saveInit(int uid);
}
