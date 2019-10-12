package com.jyj.mybatisdemo;

import com.jyj.mybatisdemo.dao.UserDao;
import com.jyj.mybatisdemo.domain.Item;
import com.jyj.mybatisdemo.domain.Order;
import com.jyj.mybatisdemo.domain.User;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        UserDao dao = new UserDao();
        User user = new User();
        user.setName("kk");
        user.setAge(12);
        dao.insert(user);
        System.out.println(dao.selectOne(1).getName());
    }

    public static SqlSession getSqlSession() throws Exception {
        //指定配置文件的路径(类路径)
        String resource = "mybatis-config.xml";
        //加载文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂Builder,相当于连接池
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sf开启会话，相当于打开连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    @Test
    public void insert() throws Exception {
        SqlSession sqlSession = getSqlSession();
        User user = new User();
        user.setAge(1);
        user.setName("Tom");
        sqlSession.insert("users.insert", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() throws Exception {
        SqlSession sqlSession = getSqlSession();
        User user = new User();
        user.setName("Jerry");
        user.setAge(2);
        user.setId(1);
        sqlSession.update("users.update", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectOne() throws Exception {
        SqlSession sqlSession = getSqlSession();
        User user = sqlSession.selectOne("users.selectOne", 1);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getAge());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAll() throws Exception {
        SqlSession sqlSession = getSqlSession();
        List<User> userList = sqlSession.selectList("users.selectAll");
        for (User user :
                userList) {
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getAge());
            System.out.println();
        }
    }

    @Test
    public void insertOrder() throws Exception {
        SqlSession sqlSession = getSqlSession();
        User user = sqlSession.selectOne("users.selectOne", 1);
        Order order = new Order();
        order.setOrderNo("No0005");
        order.setUser(user);
        sqlSession.insert("orders.insert", order);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateOrder() throws Exception {
        SqlSession sqlSession = getSqlSession();
        Order order = sqlSession.selectOne("orders.selectOne", 5);
//        sqlSession.commit();
//        sqlSession.close();
        System.out.println(order.getId());
        System.out.println(order.getOrderNo());
        System.out.println(order.getUser().getName());
        System.out.println(order.getUser().getAge());

        order.setOrderNo("No005");
        sqlSession.update("orders.update", order);

        order = sqlSession.selectOne("orders.selectOne", 5);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(order.getId());
        System.out.println(order.getOrderNo());
        System.out.println(order.getUser().getName());
        System.out.println(order.getUser().getAge());
    }

    @Test
    public void selectAllOrder() throws Exception {
        SqlSession sqlSession = getSqlSession();
        List<Order> orderList = sqlSession.selectList("orders.selectAll");
        sqlSession.commit();
        sqlSession.close();
        for (Order order :
                orderList) {
            System.out.println(order.getId());
            System.out.println(order.getOrderNo());
            System.out.println(order.getUser().getName());
            System.out.println(order.getUser().getAge());
            System.out.println();
        }
    }

    @Test
    public void selectOneOrder() throws Exception {
        SqlSession sqlSession = getSqlSession();
        Order order = sqlSession.selectOne("orders.selectOne", 1);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("orderId:" + order.getId());
        System.out.println("orderNo:" + order.getOrderNo());
        System.out.println("userId:" + order.getUser().getId());
        System.out.println("userName:" + order.getUser().getName());
        System.out.println("userAge:" + order.getUser().getAge());
        List<Item> items = order.getItems();
        for (Item item :
                items) {
            System.out.println("itemId:" + item.getId());
            System.out.println("itemName:" + item.getItemName());
//            System.out.println("Order:" + item.getOrder().getOrderNo());
        }
    }
}
