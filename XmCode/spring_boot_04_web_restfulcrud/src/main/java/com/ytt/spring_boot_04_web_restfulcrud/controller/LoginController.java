package com.ytt.spring_boot_04_web_restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {
    //与login的表单请求一一对应
    @PostMapping(value = "/user/login")
   // @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HashMap<String,Object> map, HttpSession session){
       if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
           //登陆成功,防止表单重复提交,采用重定向
            session.setAttribute("loginUser",username   );
           return "redirect:/main";
       }else {
           //提示错误信息
           map.put("msg","登陆失败,用户名或密码错误");
           return "/login";
       }
    }
}
