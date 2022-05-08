package com.example.demo.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;

import java.util.Date;


public class Test {
    public static void main(String[] args) {
        String a = "2017-05-06";
        Date date = Convert.toDate(a);

        int i = DateUtil.dayOfMonth(date);
        System.out.println(i);
    }

    public static void fun() {
        System.out.println("Test类的方法");
    }

        public void ll(){
            System.out.println("Test类的方法ll");
        }
    }