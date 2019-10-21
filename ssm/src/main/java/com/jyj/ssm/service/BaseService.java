package com.jyj.ssm.service;

import java.util.List;

/**
 * @Classname BaseService
 * @Description TODO
 * @Date 2019/10/12 10:57 下午
 * @Created by lipeijing
 */
public interface BaseService<T> {
    public void insert(T t);

    public void update(T t);

    public void delete(Integer id);

    public T selectOne(Integer id);

    public List<T> selectAll();

    public int selectCount();

    public List<T> selectByPage(int offset, int recordPerPage);
}
