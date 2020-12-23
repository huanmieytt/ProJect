package com.ytt.spring_boot_04_web_restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;

@Controller
public class HelloController {

    /*默认访问首页
        /: 当前项目
        /index : 浏览器输入index
     */
//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "success";
//    }
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello!";
    }

    @RequestMapping("/success")
    public String success(HashMap<String,Object> map){
        map.put("hello","<h1>您好!</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}

