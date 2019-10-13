package com.jyj.springmybatisdemo.dao.impl;

import com.jyj.springmybatisdemo.dao.BaseDao;
import com.jyj.springmybatisdemo.domain.Order;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname orderDao
 * @Description TODO
 * @Date 2019/10/12 10:54 下午
 * @Created by lipeijing
 */
@Repository
public class OrderDaoImpl extends SqlSessionDaoSupport implements BaseDao<Order> {
    public void insert(Order order) {
        getSqlSession().insert("orders.insert", order);
    }

    public void update(Order order) {
        getSqlSession().update("orders.update", order);
    }

    public void delete(Integer id) {
        getSqlSession().delete("orders.delete", id);
    }

    public Order selectOne(Integer id) {
        return getSqlSession().selectOne("orders.selectOne", id);
    }

    public List<Order> selectAll() {
        return getSqlSession().selectList("orders.selectAll");
    }
}
