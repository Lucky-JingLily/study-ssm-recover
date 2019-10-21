package com.jyj.ssm.dao;

import java.util.List;

/**
 * @Classname BaseDao
 * @Description TODO
 * @Date 2019/10/12 10:07 下午
 * @Created by lipeijing
 */
public interface BaseDao<T> {
    public void insert(T t);
    public void update(T t);
    public void delete(Integer id);
    public T selectOne(Integer id);
    public List<T> selectAll();
    public List<T> selectByPage(int offset, int len);
    public int selectCount();
}
