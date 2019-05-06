package com.ttesc.ddaycar_serveruser.service.impl;

import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.dao.UserDao;
import com.ttesc.ddaycar_serveruser.dao.UserDetailDao;
import com.ttesc.ddaycar_serveruser.dao.UserWalletDao;
import com.ttesc.ddaycar_serveruser.service.UserService;
import com.ttesc.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:34
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDetailDao detailDao;
    @Autowired
    private UserWalletDao walletDao;
    @Override
    @Transactional
    public ResultVO register(User user) {
        //用户注册之后
        //1、新增用户
        userDao.save(user);
        //2、新增用户详情
        detailDao.saveInit(user.getId());
        //3、新增用户钱包
        walletDao.saveInit(user.getId());

        return ResultUtil.exec(true,"新增用户成功",null);
    }

    @Override
    public ResultVO checkPhone(String phone) {
        User user=userDao.selectByPhone(phone);
        return ResultUtil.exec(user==null,"手机号",null);
    }
}
