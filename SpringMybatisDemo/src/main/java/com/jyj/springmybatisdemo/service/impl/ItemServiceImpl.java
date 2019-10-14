package com.jyj.springmybatisdemo.service.impl;

import com.jyj.springmybatisdemo.dao.BaseDao;
import com.jyj.springmybatisdemo.domain.Item;
import com.jyj.springmybatisdemo.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/10/12 11:45 下午
 * @Created by lipeijing
 */
@Service("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {
    /*** 重写该方法，注入指定的Dao对象 ***/
    @Resource(name="itemDao")
    public void setDao(BaseDao<Item> dao) {
        super.setDao(dao);
    }
}