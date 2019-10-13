package com.jyj.springdemo;

import com.jyj.springdemo.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname App
 * @Description TODO
 * @Date 2019/10/12 11:23 上午
 * @Created by lipeijing
 */
public class App {
    public static void main(String[] args) {
        //创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        WelcomeService ws = (WelcomeService)ac.getBean("ws");
        ws.sayHello();
    }
}
