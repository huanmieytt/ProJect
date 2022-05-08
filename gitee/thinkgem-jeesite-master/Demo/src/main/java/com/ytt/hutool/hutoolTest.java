package com.ytt.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class hutoolTest {
    private static Integer offset =  3;

    public static void test(){
        String a = "2021-03-21";
        Date date = Convert.toDate(a);

        int i = DateUtil.dayOfMonth(date);
//        实现日期的加减
        Date dateAfterDays = DateUtil.offsetDay(date, offset);
        Date dateABeforeDays = DateUtil.offsetDay(date, -offset);

        System.out.println(date+"是月中的第 "+ i +"天！");
        System.out.println(date+"的"+offset+"天前是："+dateAfterDays);
        System.out.println(date+"的"+offset+"天后是："+dateABeforeDays);


        System.out.println(date);
    }
    public static void main(String[] args) {
        test();
//        System.out.println("11111111");
    }
}
