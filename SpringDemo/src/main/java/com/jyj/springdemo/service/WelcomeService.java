package com.jyj.springdemo.service;

import com.jyj.springdemo.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname WelcomeService
 * @Description TODO
 * @Date 2019/10/12 11:22 上午
 * @Created by lipeijing
 */
@Service("ws")
public class WelcomeService {
    private String message;
    private UserDao dao;

    @Resource(name = "userDao")
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHello() {
        System.out.println(message);
        dao.insert();
    }
}
