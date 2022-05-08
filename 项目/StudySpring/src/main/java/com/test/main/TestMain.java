package com.test.main;


import com.test.main.service.UserService;
import com.test.main.service.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = (UserService)applicationContext.getBean("userService");
        System.out.println(applicationContext.getBean("userService"));
        System.out.println(applicationContext.getBean("userService"));
        //System.out.println(applicationContext.getBean("orderService"));
        //System.out.println(applicationContext.getBean("orderService1"));
        //System.out.println(applicationContext.getBean("orderService2"));

        userService.test();

    }


}
