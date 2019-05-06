package com.ttesc.entity.award;

import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2019/4/30 15:17
 * 抽奖
 */
public class Award {
    private int id;
    private Date createtime;
    private int level;//几等奖
    private String levelmsg;//几等奖
    private String award;//奖品
    private int uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getLevelmsg() {
        return levelmsg;
    }

    public void setLevelmsg(String levelmsg) {
        this.levelmsg = levelmsg;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getSocre() {
        return socre;
    }

    public void setSocre(int socre) {
        this.socre = socre;
    }

    private int socre;//消耗的积分

}
