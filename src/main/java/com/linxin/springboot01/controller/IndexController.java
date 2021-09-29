package com.linxin.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author linxin
 * @date 9/27/2021 - 2:42 PM
 * @file IndexController.java
 * @function 返回首页
 */
@Controller
public class IndexController {
    @RequestMapping({"/","index.html"})
    public String index(){
        return "index";
    }

}
