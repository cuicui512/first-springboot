package com.linxin.springboot01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author linxin
 * @date 9/27/2021 - 5:32 PM
 * @file MyMvcConfig.java
 * @function 自定义的MVC配置类
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override // 重写视图
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("main.html").setViewName("dashboard");

    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) { // 拦截所有页面，排除需要放行的页面
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/*").excludePathPatterns("/index.html","/user/login","/","/css/*","/js/*","/img/*");

    }
}
