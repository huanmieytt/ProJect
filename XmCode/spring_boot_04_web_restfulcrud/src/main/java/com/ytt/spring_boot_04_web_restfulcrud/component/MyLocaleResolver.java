package com.ytt.spring_boot_04_web_restfulcrud.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 配置国际化
 * 在连接上获取国际信息, 需实现LocaleResolver接口
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //前台点击中英文连接所带过来的参数值
        /**
         关于locale
         Locale(String language)
         Locale(String language, String country)
         Locale(String language, String country, String variant)
         */
        String language =  httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
//            第一个元素为语言,第二个元素为国家
           locale =  new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
