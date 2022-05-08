package com.test.main.service.config;

import com.test.main.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.test")
public class SpringConfig {
    //
    @Bean
    public OrderService orderService(){
        return new OrderService();
    }
    @Bean
    public OrderService orderService1(){
        return new OrderService();

    }
    @Bean
    public OrderService orderService2(){
        return new OrderService();

    }


}
