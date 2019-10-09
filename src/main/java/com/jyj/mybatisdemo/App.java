package com.jyj.mybatisdemo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws IOException {
        //指定配置文件的路径(类路径)
        String resource = "mybatis-config.xml";
        //加载文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂Builder,相当于连接池
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);

        //通过sf开启会话，相当于打开连接。
        SqlSession s = sf.openSession();
        System.out.println(s);
    }
}
