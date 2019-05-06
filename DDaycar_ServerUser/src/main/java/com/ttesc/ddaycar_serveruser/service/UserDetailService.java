package com.ttesc.ddaycar_serveruser.service;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.dao.UserDetailDao;
import com.ttesc.entity.user.Userdetail;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:40
 */
public interface UserDetailService {

    ResultVO updateDetail(Userdetail userdetail);
    ResultVO queryByUid(int uid);
}
