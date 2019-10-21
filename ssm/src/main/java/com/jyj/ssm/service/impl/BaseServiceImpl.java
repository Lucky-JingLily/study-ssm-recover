package com.jyj.ssm.service.impl;

import com.jyj.ssm.dao.BaseDao;
import com.jyj.ssm.service.BaseService;

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

    public List<T> selectByPage(int offset, int len) {
        return dao.selectByPage(offset, len);
    }
    public int selectCount() {
        return dao.selectCount();
    }
}
