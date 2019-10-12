package com.jyj.mybatisdemo.dao;

import com.jyj.mybatisdemo.util.Util;
import org.apache.ibatis.session.SqlSession;

/**
 * @Classname DaoTemple
 * @Description TODO
 * @Date 2019/10/11 2:21 下午
 * @Created by lipeijing
 */
public class DaoTemple {
    public static Object execute(MybatisCallback callback) {
        SqlSession sqlSession = null;
        try {
            sqlSession = Util.openSession();
            Object ret = callback.doInMybatis(sqlSession);
            sqlSession.commit();
            return ret;
        } catch (Exception e) {
            Util.rollbackTx(sqlSession);
        } finally {
            Util.closeSesion(sqlSession);
        }
        return null;
    }
}
