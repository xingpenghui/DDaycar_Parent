package com.ttesc.ddaycar_serveruser.sevrice.impl;

import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.dao.UserDao;
import com.ttesc.ddaycar_serveruser.sevrice.UserService;
import com.ttesc.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:34
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public ResultVO register(User user) {

        return ResultUtil.exec(userDao.save(user)>0,"新增用户成功",null);
    }
}
