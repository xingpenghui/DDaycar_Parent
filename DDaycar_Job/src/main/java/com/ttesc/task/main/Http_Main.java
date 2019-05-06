package com.ttesc.task.main;

import com.ttesc.task.util.HttpUtil;

/**
 *@Author feri
 *@Date Created in 2019/5/6 15:57
 */
public class Http_Main {
    public static void main(String[] args) {
        System.out.println(HttpUtil.getStr("http://localhost:9099/elastic/page.do?index=java1808qq&limit=20&page=1&type=project"));
    }
}
