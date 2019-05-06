package com.ttesc.ddaycar_serveruser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netflix.discovery.converters.Auto;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.dao.UserDetailDao;
import com.ttesc.ddaycar_serveruser.service.UserDetailService;
import com.ttesc.entity.user.Userdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:42
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserDetailDao detailDao;
    @Override
    public ResultVO updateDetail(Userdetail userdetail) {
        int r=detailDao.update(userdetail,new QueryWrapper<Userdetail>().eq("uid",userdetail.getUid()));

        return ResultUtil.exec(r>0,"完善个人资料",null);
    }

    @Override
    public ResultVO queryByUid(int uid) {
        return ResultUtil.exec(true,"OK",detailDao.selectOne(new QueryWrapper<Userdetail>().eq("uid",uid)));
    }
}
