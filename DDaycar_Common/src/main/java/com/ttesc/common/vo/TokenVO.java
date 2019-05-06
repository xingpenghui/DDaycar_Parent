package com.ttesc.common.vo;

import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2019/4/29 14:47
 */
public class TokenVO {
    private int uid;//用户的id
    private Date date;//时间戳
    private long random;//随机数
    private String content;//用户详细内容的json格式

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getRandom() {
        return random;
    }

    public void setRandom(long random) {
        this.random = random;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
