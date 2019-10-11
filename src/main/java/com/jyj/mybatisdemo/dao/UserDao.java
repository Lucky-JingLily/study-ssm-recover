package com.jyj.mybatisdemo.dao;

import com.jyj.mybatisdemo.domain.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2019/10/11 2:29 下午
 * @Created by lipeijing
 */
public class UserDao {
    public void insert(final User user) {
        DaoTemple.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession sqlSession) {
                sqlSession.insert("users.insert", user);
                return null;
            }
        });
    }

    public void update(final User user) {
        DaoTemple.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession sqlSession) {
                sqlSession.update("users.update", user);
                return null;
            }
        });
    }

    public User selectOne(final Integer id) {
        return (User)DaoTemple.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession sqlSession) {
                return sqlSession.selectOne("users.selectOne", id);
            }
        });
    }

    public List<User> selectAll() {
        return (List<User>)DaoTemple.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession sqlSession) {
                return sqlSession.selectList("users.selectAll");
            }
        });
    }
}