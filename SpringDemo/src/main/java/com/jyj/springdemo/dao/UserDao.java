package com.jyj.springdemo.dao;

import org.springframework.stereotype.Repository;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2019/10/12 2:55 下午
 * @Created by lipeijing
 */
@Repository("userDao")
public class UserDao {
    public void insert() {
        System.out.println("insert over");
    }
}
