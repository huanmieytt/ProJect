package com.ytt.spring_boot_04_web_restfulcrud.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器,在用户登陆之前拦截
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {

    //实现 preHandle 的方法,在目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            //未登陆,提示错误消息,返回登陆界面
            request.setAttribute("msg","没有权限,请重新登陆");
           request.getRequestDispatcher("index").forward(request,response);
            return false;
        }else{
            //以登陆
            return true;
        }

    }
}
