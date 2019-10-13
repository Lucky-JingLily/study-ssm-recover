package com.jyj.springmybatisdemo.service.impl;

import com.jyj.springmybatisdemo.dao.BaseDao;
import com.jyj.springmybatisdemo.domain.User;
import com.jyj.springmybatisdemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/10/12 11:45 下午
 * @Created by lipeijing
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    /*** 重写该方法，注入指定的Dao对象 ***/
    @Resource(name="userDao")
    public void setDao(BaseDao<User> dao) {
        super.setDao(dao);
    }
}