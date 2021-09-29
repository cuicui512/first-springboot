package com.linxin.springboot01.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author linxin
 * @date 9/27/2021 - 5:19 PM
 * @file LoginHandlerInterceptor.java
 * @function 自定义拦截器，实现登录拦截器
 */
// 拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 重写方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后应该有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser==null){// loginUser为空，表示没有登录
            request.setAttribute("msg","没有权限，请先登录");
            // 返回到index.html
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return  true;
        }


    }
}
