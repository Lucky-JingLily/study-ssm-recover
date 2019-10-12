package com.jyj.mybatisdemo.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Classname Util
 * @Description TODO
 * @Date 2019/10/10 1:11 下午
 * @Created by lipeijing
 */
public class Util {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    public static void closeSesion(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    public static void rollbackTx(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }
}
