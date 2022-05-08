package com.suanfa.Test1_maxString;

import java.util.ArrayList;
import java.util.List;

public class test1_maxString {
    public static void main(String[] args) {
        String a = "abcdabcefbb";
        List<Character> ca = new ArrayList<>();
        char[]  chars= a.toCharArray();
        fun(chars,ca);
    }

    private static void fun(char[] chars,List<Character> ca) {
        ca.add(chars[0]);
        for(int i = 1;i<chars.length;i++){
            if(!ca.contains(chars[i])){
                ca.add(chars[i]);
            }else{
                for(Character result:ca){
                    System.out.print(result);
                }
                break;
            }
//            ca.add(chars[i]);
//            if(i > 0){
//                ca.contains(chars[i]);
//            }
        }
    }
}
