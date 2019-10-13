package com.jyj.springmybatisdemo.service.impl;

import com.jyj.springmybatisdemo.dao.BaseDao;
import com.jyj.springmybatisdemo.service.BaseService;

import java.util.List;

/**
 * @Classname BaseServiceImpl
 * @Description TODO
 * @Date 2019/10/12 11:20 下午
 * @Created by lipeijing
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    private BaseDao<T> dao;

    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }

    public void insert(T t) {
        dao.insert(t);
    }

    public void update(T t) {
        dao.update(t);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }

    public T selectOne(Integer id) {
        return dao.selectOne(id);
    }

    public List<T> selectAll() {
        return dao.selectAll();
    }
}
