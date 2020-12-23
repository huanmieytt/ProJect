package com.web01.demo;

import com.web01.app.AppConfig;
import com.web01.services.IndexService;
import com.web01.services.UserService;
import org.assertj.core.data.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


public class TestService {

    public static void main(String[] args) {
        //初始化 spring容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
       ac.getBean(IndexService.class).getService();
     //  ac.getBean(UserService.class).getIndexService();
    }

}
