package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class paramController {
    public static String Page = "parm";
    @RequestMapping("param")
    public ModelAndView param(@RequestParam("id") int id) {
        System.out.println("id = " + id);
        ModelAndView modelAndView = new ModelAndView(Page);
        modelAndView.addObject("id",id);
        return modelAndView;
    }
}
