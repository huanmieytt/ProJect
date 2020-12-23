package com.web01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class IndexService {

    @Autowired
    public UserService userService;
    public IndexService(){
        System.out.println("---构造方法：IndexService------");
    }

    public void getService(){
        System.out.println(userService);
    }
}
