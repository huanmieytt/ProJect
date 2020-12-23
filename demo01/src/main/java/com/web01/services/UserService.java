package com.web01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserService {
    @Autowired
    public IndexService indexService;
    public UserService(){
        System.out.println("-------构造方法UserService---------");
    }

    public void soutUserService(){
        System.out.println("-----函数方法：userService-------");
    }
   /* public void getIndexService(){
        indexService.soutIndexService();
    }*/
}
