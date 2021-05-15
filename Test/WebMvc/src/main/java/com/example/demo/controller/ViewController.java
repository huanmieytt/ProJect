package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
    public static String Page = "view";

    /**
     * 不带数据返回页面
     * @return
     */
    @RequestMapping("view")
    public String view(){
        return Page;
    }

    /**
     * 带数据返回页面，modelandview 对象返回
     * @return
     */
    @RequestMapping("data")
    public String data(Model model){
        model.addAttribute("str1","大家好，我是hello!!");
        model.addAttribute("str2","大家好，我是world!!");
        return "page";
    }

}
