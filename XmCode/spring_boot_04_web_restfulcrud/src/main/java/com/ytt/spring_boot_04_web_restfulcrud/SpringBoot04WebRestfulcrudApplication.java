package com.ytt.spring_boot_04_web_restfulcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@SpringBootApplication
public class SpringBoot04WebRestfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04WebRestfulcrudApplication.class, args);
    }

    //视图解析器
    public ViewResolver getViewResolver(){
        return new MyViewResolver();
    }
    public static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }


}
