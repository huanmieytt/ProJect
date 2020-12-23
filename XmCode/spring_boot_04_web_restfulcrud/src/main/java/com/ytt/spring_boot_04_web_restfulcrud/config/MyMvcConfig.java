package com.ytt.spring_boot_04_web_restfulcrud.config;


import com.ytt.spring_boot_04_web_restfulcrud.component.LoginHandlerInterceptor;
import com.ytt.spring_boot_04_web_restfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.registry.Registry;
import java.util.Locale;

//继承 WebMvcConfigure 扩展springmvc的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
//        浏览器发送 /atyt 请求 也跳转到 success 页面
        registry.addViewController("/atyt").setViewName("success");
    }

    //所有的WebMvcConfigurer 都会起作用
    //将组件注册在容器中
    @Bean
   public  WebMvcConfigurer myWebMvcConfigurer(){
       WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("main").setViewName("dashboard");
            }
            //拦截器
           public void addInterceptors(InterceptorRegistry registry) {
                //拦截任意多层路径下的任意请求
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
               //排除以下这些请求,也就使登陆界面的请求,还有静态资源
                .excludePathPatterns("/","/index","/user/login","/asserts/**");
           }
       };

       return  webMvcConfigurer;
   }

    /**
     * 方法名得是localResolver 不然国际化不起作用
     */
   @Bean
   public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
   }


}
