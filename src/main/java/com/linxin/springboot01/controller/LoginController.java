package com.linxin.springboot01.controller;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author linxin
 * @date 9/27/2021 - 4:21 PM
 * @file LoginController.java
 * @function 实现登录跳转
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    // 接收来自index.html页面input标签中的输入内容
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){

        System.out.println("login()函数");
        System.out.println("username: "+username+" password: "+password);
        System.out.println(StringUtils.isEmpty(username));
        System.out.println("123456".equals(password));
        // 具体的业务:判断用户名和密码
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            // 获取用户的session
            session.setAttribute("loginUser",username);
            //用户名不为空和密码为123456，登录成功
            System.out.println("登录成功！");
            return "redirect:/main.html";
        }else {
            //登录失败
            model.addAttribute("msg","用户名或密码错误!");
            System.out.println("登录失败！");
            return "index";
        }

    }

    // 注销登录实现
    @RequestMapping("user/logout")
    public String logout(HttpSession session){
        // session无效即可
        session.invalidate();
        return "redirect:/index.html";
    }

}
