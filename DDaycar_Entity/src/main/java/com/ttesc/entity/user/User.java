package com.ttesc.entity.user;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/4/28 16:59
 */
@Data
public class User {
    private int id;
    private String phone;
    private String password;
    private int flag;
}