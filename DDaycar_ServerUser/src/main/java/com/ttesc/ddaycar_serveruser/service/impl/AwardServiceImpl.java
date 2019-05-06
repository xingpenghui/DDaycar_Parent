package com.ttesc.ddaycar_serveruser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ttesc.common.constsys.SystemConst;
import com.ttesc.common.util.JedisUtil;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.util.TimeUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.dao.AwardDao;
import com.ttesc.ddaycar_serveruser.dao.ScoreTimeDao;
import com.ttesc.ddaycar_serveruser.dao.UserWalletDao;
import com.ttesc.ddaycar_serveruser.service.AwardService;
import com.ttesc.entity.award.Award;
import com.ttesc.entity.user.Scoretime;
import com.ttesc.entity.user.Userwallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@Author feri
 *@Date Created in 2019/4/30 14:54
 */
@Service
public class AwardServiceImpl implements AwardService {

    @Autowired
    private UserWalletDao walletDao;
    @Autowired
    private ScoreTimeDao scoreTimeDao;
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private AwardDao awardDao;
    @Override
    public ResultVO queryScore(int uid) {
        return ResultUtil.exec(true,"OK",walletDao.selectOne(
                new QueryWrapper<Userwallet>().eq("uid",uid)));
    }

    @Override
    @Transactional
    public ResultVO startAward(int uid) {
        //抽奖逻辑
        Random random=new Random();
        //使用Lock锁，必须要手动释放 要放在finally
        Lock lock=new ReentrantLock();
        try{
            lock.lock();
            if(jedisUtil.isExists("ddaycar_cjcs")){
                jedisUtil.incre("ddaycar_cjcs");
            }else {
                jedisUtil.setStr("ddaycar_cjcs","1");
            }
        }finally {
            lock.unlock();
        }

        long count=Long.parseLong(jedisUtil.getStr("ddaycar_cjcs"));
        //遇到10000就产生大奖
        int level=8;
        if(count%(random.nextInt(10000)+9000)==0){
            level=5;
        }else {
            if(count%100==0 ){
                level=random.nextInt(3)+6;
            }else {
                level=random.nextInt(2)+7;
            }
        }
        int socre=-SystemConst.CJSCORE;
        String lmsg="";
        switch (level){
            case 5:
                lmsg="五等奖";
                break;
            case 6:
                lmsg="六等奖";
                socre+=100;
                break;
            case 7:
                lmsg="七等奖";
                socre+=19;
                break;
            case 8:
                lmsg="八等奖";
                socre+=1;
                break;
        }
        Award award=new Award();
        award.setUid(uid);
        award.setLevelmsg(lmsg);
        award.setAward(SystemConst.JX[level-1]);
        award.setLevel(level);
        award.setCreatetime(new Date());
        award.setSocre(SystemConst.CJSCORE);
        awardDao.insert(award);
        walletDao.updateByScore(socre, uid);
        //操作数据库 记得加上中奖的积分
        if(socre>-SystemConst.CJSCORE) {
            Scoretime scoretime = new Scoretime();
            scoretime.setType(SystemConst.CJTYPE);
            scoretime.setStartdate(new Date());
            scoretime.setDays(SystemConst.SCOREEXPIRE);
            scoretime.setEnddate(TimeUtil.add(SystemConst.SCOREEXPIRE));
            scoretime.setUid(uid);
            scoretime.setScore(socre + SystemConst.CJSCORE);
            scoreTimeDao.insert(scoretime);
        }
        return ResultUtil.exec(true,"OK",award);
    }
}
