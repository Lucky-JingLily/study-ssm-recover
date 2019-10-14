package com.jyj.myspringmvc.web.controller;

import com.jyj.myspringmvc.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname DB
 * @Description TODO
 * @Date 2019/10/14 3:50 下午
 * @Created by lipeijing
 */
public class DB {
    private static Map<Integer, User> usertable = new HashMap<Integer, User>();

    static {
        for (int i = 0; i < 15; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setName("tom" + (i + 1));
            user.setAge(i % 20);
            usertable.put(i + 1, user);
        }
    }

    public static List<User> selectAll() {
        return new ArrayList<User>(usertable.values());
    }

    public static User selectOne(Integer uid) {
        return usertable.get(uid);
    }

    public static void update(User user) {
        usertable.put(user.getId(), user);
        System.out.println(user.getId());
    }

    public static void delete(Integer uid) {
        usertable.remove(uid);
    }

    public static void deleteAll() {
        usertable.clear();
    }
}
