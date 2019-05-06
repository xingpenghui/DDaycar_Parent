package com.ttesc.ddaycar_serveruser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.dao.UserWalletDao;
import com.ttesc.ddaycar_serveruser.service.UserWalletService;
import com.ttesc.entity.user.Userwallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:45
 */
@Service
public class UserWalletServiceImpl implements UserWalletService {
    @Autowired
    private UserWalletDao walletDao;
    @Override
    public ResultVO updateTotalScore(int uid, int tscore) {

        return ResultUtil.exec(walletDao.updateByScore(uid, tscore)>0,"修改总积分",null);
    }

    @Override
    public ResultVO updateLoseScore(int uid, int lscore) {
        return ResultUtil.exec(walletDao.updateByLoseScore(uid, lscore)>0,"修改失效积分",null);
    }

    @Override
    public ResultVO queryByUid(int uid) {

        return ResultUtil.exec(true,"OK",walletDao.selectOne(new QueryWrapper<Userwallet>().eq("uid",uid)));
    }
}
