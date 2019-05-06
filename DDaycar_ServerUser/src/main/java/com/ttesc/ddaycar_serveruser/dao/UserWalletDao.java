package com.ttesc.ddaycar_serveruser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttesc.entity.user.Userwallet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:04
 */
public interface UserWalletDao extends BaseMapper<Userwallet> {
    //新增
    @Insert("insert into userwallet(uid) values(#{uid})")
    int saveInit(int uid);
    //查询
    //修改
    @Update("update userwallet set totalscore=totalscore+#{score} where uid=#{uid}")
    int updateByScore(@Param("score") int score, @Param("uid") int uid);
    @Update("update userwallet set losescore=losescore+#{score} where uid=#{uid}")
    int updateByLoseScore(@Param("score") int score, @Param("uid") int uid);

}
