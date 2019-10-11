package com.jyj.mybatisdemo.dao;

import org.apache.ibatis.session.SqlSession;

/**
 * @Classname MybatisCallback
 * @Description TODO
 * @Date 2019/10/11 2:22 下午
 * @Created by lipeijing
 */
public interface MybatisCallback {
    public Object doInMybatis(SqlSession sqlSession);
}
