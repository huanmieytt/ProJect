package com.web01.demo;

import com.web01.app.AppConfig;
import com.web01.services.IndexService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ac.getBean(IndexService.class).getService();
    }

}
