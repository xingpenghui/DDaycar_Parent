package com.ttesc.ddaycar_serveruser.service.impl;

import com.ttesc.common.constsys.SystemConst;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_serveruser.dao.ScoreTimeDao;
import com.ttesc.ddaycar_serveruser.dao.UserSignDao;
import com.ttesc.ddaycar_serveruser.dao.UserWalletDao;
import com.ttesc.ddaycar_serveruser.service.UserSignService;
import com.ttesc.entity.user.Scoretime;
import com.ttesc.entity.user.Usersign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 *@Author feri
 *@Date Created in 2019/4/30 10:10
 */
@Service
public class UserSignServiceImpl implements UserSignService  {
    @Autowired
    private UserSignDao signDao;
    @Autowired
    private UserWalletDao walletDao;
    @Autowired
    private ScoreTimeDao timeDao;
    @Override
    @Transactional //事务
    public ResultVO sign(int uid) {
        //签到
        //今天有没有签过道
        Usersign usersign=signDao.selectLastSign(uid);
        Random random=new Random();
        int score=random.nextInt(20)+1;
        int tarscore=0;
        int days=0;
        if(usersign==null){
            //没有过签到记录  第一次签到赠送100积分
            tarscore=score+100;
            days=1;
        }else{
            //签道过
            //是否连续
            //今天是否签到
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(usersign.getCreatetime());
            int last=calendar.get(Calendar.DAY_OF_YEAR);
            Calendar calendarnow=Calendar.getInstance();
            int nowdays=calendarnow.get(Calendar.DAY_OF_YEAR);
            if(nowdays==last){
                //今天签过道
                tarscore=0;
            }else {
                //今天没签到
                //是否连续签到
                if(nowdays-last==1){
                    days=usersign.getDays()+1;
                    if(days%30==0){
                        //连续签到30 或者30天的倍数  奖励4倍
                        if(score<5){
                            score=5;
                        }
                        tarscore=4*score;
                    }else if(days%5==0){
                        tarscore=score+5;
                    }else if(days%3==0){
                        tarscore=2*score;
                    }
                }else if(nowdays-last>1){
                    days=1;
                    //断签
                    if(usersign.getDays()>=30){
                        tarscore=2*score;
                    }else {
                        tarscore=score;
                    }
                }
            }
        }
        if(tarscore==0){
            //签过道
            return ResultUtil.setERROR();
        }else {
            //签到操作
            Usersign usersign1=new Usersign();
            usersign1.setUid(uid);
            usersign1.setDays(days);
            usersign1.setCreatetime(new Date());
            usersign1.setScore(tarscore);
            signDao.insert(usersign1);
            //钱包操作
            walletDao.updateByScore(tarscore,uid);
            //积分有效期表
            Scoretime scoretime=new Scoretime();
            scoretime.setUid(uid);
            scoretime.setStartdate(new Date());
            scoretime.setDays(SystemConst.SCOREEXPIRE);
            //计算失效日期
            Calendar endcalendar=Calendar.getInstance();
            endcalendar.add(Calendar.DAY_OF_YEAR,SystemConst.SCOREEXPIRE);
            scoretime.setEnddate(endcalendar.getTime());
            scoretime.setType(SystemConst.SIGNTYPE);
            timeDao.insert(scoretime);

            return ResultUtil.exec(true,"签到成功",tarscore);
        }
    }

    @Override
    public ResultVO queryMonth(int uid) {
        //查询30天内的签到数据
        List<Usersign> list=signDao.selectByDays(uid);
        List<Usersign> usersigns=new ArrayList<>();
        Date date=new Date();
        for(Usersign us:list){
            if(date.getTime()-us.getCreatetime().getTime()<=30*24*60*60){
                usersigns.add(us);
            }else {
                break;
            }
        }
        return ResultUtil.exec(true,"OK",usersigns);
    }
}
