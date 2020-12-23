package com.web01.demo.controller;

import com.web01.demo.pojo.Person;
import com.web01.demo.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    public PersonServiceImpl personService;

    @RequestMapping("/findPerson")
    public ModelAndView persons(){
        ModelAndView mv = new ModelAndView();
        Person person = new Person();
        person.setPid(1);

        Person person1 = personService.selectById(person.getPid());
        mv.addObject("person",person1);

        //要跳转的html页面
       mv.setViewName("person");
       return mv;
    }



}
