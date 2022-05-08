package com.test.main.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService implements InitializingBean {
    @Autowired
    private OrderService orderService;


    @PostConstruct
    public void before(){
        System.out.println("方法前加PostConstruct注解，是在实例化bean前就调用的;");

    }

    public void test(){
        System.out.println(orderService);
    }

    public void afterPropertiesSet() throws Exception {
        //初始化方法
        cshFunc();
    }

    private void cshFunc() {
        System.out.println("bean在初始化时调用的实现InitializingBean接口的 afterPropertiesSet（）方法");
    }
}
