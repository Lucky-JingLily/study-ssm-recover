package com.jyj.springmybatisdemo.test;

import com.jyj.springmybatisdemo.domain.Item;
import com.jyj.springmybatisdemo.domain.Order;
import com.jyj.springmybatisdemo.domain.User;
import com.jyj.springmybatisdemo.service.ItemService;
import com.jyj.springmybatisdemo.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Classname TestConnect
 * @Description TODO
 * @Date 2019/10/12 8:59 下午
 * @Created by lipeijing
 */
public class TestConnect {
    @Test
    public void getConnect() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertUser() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setName("lili");
        user.setAge(12);
        userService.insert(user);
    }

    @Test
    public void selectOneUser() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");

        User user = userService.selectOne(1);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }

    @Test
    public void insertItem() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ItemService itemService = (ItemService) applicationContext.getBean("itemService");

        Item item = new Item();
        item.setItemName("ii00001");
        Order order = new Order();
        order.setOrderNo("oo00001");
        order.setId(2);
        item.setOrder(order);

        itemService.insert(item);
    }

    @Test
    public void selectOneItem() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ItemService itemService = (ItemService) applicationContext.getBean("itemService");

        Item item = itemService.selectOne(2);

        System.out.println(item.getId());
        System.out.println(item.getItemName());
        System.out.println(item.getOrder().getOrderNo());
        System.out.println(item.getOrder().getUser().getName());
    }
}
