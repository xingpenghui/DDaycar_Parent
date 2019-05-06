package com.ttesc.ddaycar_serveruser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttesc.entity.user.Usersign;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/4/30 10:07
 */
public interface UserSignDao extends BaseMapper<Usersign> {

    @Select("select * from usersign where uid=#{uid} order by createtime desc limit 1")
    Usersign selectLastSign(int uid);

    @Select("select * from usersign where uid=#{uid} order by createtime desc limit 30")
    List<Usersign> selectByDays(int uid);
}
