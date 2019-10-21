package com.jyj.ssm.web.controller;

import com.jyj.ssm.dao.impl.UserDaoImpl;
import com.jyj.ssm.domain.User;
import com.jyj.ssm.service.BaseService;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2019/10/14 9:06 下午
 * @Created by lipeijing
 */
@Controller
public class UserController {

    @Resource(name = "userService")
    private BaseService<User> userBaseService;

    @RequestMapping("/user/hello")
    public String hello() {
        System.out.println("say hello");
        return "forward:/html/hello.html";
    }

    @RequestMapping("/user/findAll")
    public String findAll(Model model) {
        List<User> users = userBaseService.selectAll();
        model.addAttribute("allUsers", users);
        return "user/selectAllUsers";
    }

    @RequestMapping(value = {"/user/findByPage","/user/findAll"})
    public String findPage(Model m ,@RequestParam("pn") int pn){
        //查询总记录数
        int counts = userBaseService.selectCount();

        //每页记录数
        int recordPerPage = 5 ;

        //结算页数
        int pages = 0 ;
        if(counts % recordPerPage == 0){
            pages = counts / recordPerPage ;
        }
        else{
            pages = counts / recordPerPage + 1;
        }

        //偏移量
        int offset = (pn - 1) * recordPerPage ;
        List<User> list = userBaseService.selectByPage(offset, recordPerPage);
        m.addAttribute("allUsers", list);
        m.addAttribute("pages",pages) ;
        return "user/userList";
    }

    @RequestMapping("/user/deleteUser")
    public String deleteUser(@RequestParam("uid") int uid) {
        userBaseService.delete(uid);
        return "redirect:/user/findByPage?pn=1";
    }

    @RequestMapping("/user/editUser")
    public String editUser(Model model, @RequestParam("uid") int uid) {
        User user = userBaseService.selectOne(uid);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping(value = "/user/saveUser", method = RequestMethod.POST)
    public String saveUser(User user) {
        userBaseService.update(user);
        return "redirect:/user/findByPage?pn=1";
    }
}
