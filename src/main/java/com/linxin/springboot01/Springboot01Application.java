package com.linxin.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication: 标注这个类是一个springboot应用，启动类下的所有资源被导入
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {
        // 将springboot应用启动
        SpringApplication.run(Springboot01Application.class, args);
    }

}
