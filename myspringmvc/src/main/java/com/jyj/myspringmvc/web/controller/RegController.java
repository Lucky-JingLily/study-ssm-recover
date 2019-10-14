package com.jyj.myspringmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname HomeController
 * @Description TODO
 * @Date 2019/10/14 10:30 上午
 * @Created by lipeijing
 */
@Controller
public class RegController {

    @RequestMapping("/toReg")
    public String toRegView() {
        System.out.println("toRegView");
        return "reg";
    }

//    @RequestMapping("/doReg")
//    public String doRegView(HttpServletRequest request) {
//        System.out.println("doRegView");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println(username + ", " + password);
//        return "home";
//    }

    @RequestMapping("/doReg")
    public String doRegView(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("doRegView");
        System.out.println(username + ", " + password);
        return "home";
    }
}
