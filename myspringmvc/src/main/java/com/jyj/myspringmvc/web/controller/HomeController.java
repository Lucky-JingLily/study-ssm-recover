package com.jyj.myspringmvc.web.controller;

import com.jyj.myspringmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname HomeController
 * @Description TODO
 * @Date 2019/10/14 10:30 上午
 * @Created by lipeijing
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String openHome() {
        System.out.println("hello word");
        return "home";
    }

    @RequestMapping("/selectOne")
    public String selectOneUser(Model model, @RequestParam("uid") Integer uid) {
        System.out.println("username = tom");
        model.addAttribute("myusername", "tom");
        return "selectOne";
    }

    @RequestMapping("/selectAll")
    public String selectAll(Model m){
        List<User> userList = DB.selectAll();
        m.addAttribute("allUsers",userList);
        return "selectAll" ;
    }

    @RequestMapping("/deleteOne")
    public String deleteOne(@RequestParam("uid") Integer uid){
        DB.delete(uid);
        return "redirect:/selectAll" ;
    }

    @RequestMapping("/editOne")
    public String editOne(Model m, @RequestParam("uid") Integer uid){
        User user = DB.selectOne(uid);
        m.addAttribute(user);
        return "edit" ;
    }

    @RequestMapping("/updateOne")
    public String updateOne(User user){
        DB.update(user);
        return "forward:/selectAll" ;
    }
}
