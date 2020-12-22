package com.ytt.main;

import strman.Strman;

public class Test {
    public static void main(String[] args) {

        String s1 = Strman.append("f", "o", "o", "b", "a", "r");
        System.out.println(s1);
        String[] strs = Strman.split("aj,dk,a,j,kd,a",",");
        for(String i : strs){
            System.out.println(i);
        }
//        Boolean b = Strman.contains("aaaaab","aaaab");
//        System.out.println(b);
        String ss = "aaaabbbE";
        Boolean c = Strman.isLowerCase(ss);
        System.out.println(c);


    }
}
