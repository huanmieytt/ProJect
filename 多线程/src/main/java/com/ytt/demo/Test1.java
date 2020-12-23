package com.ytt.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Test1 {
    private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class.getName());
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            //线程的开始
            @Override
            public void run(){
                log.debug("t1线程开始打印===");
            }
        };
        t1.start();
        log.debug("主线程开始执行====");
    }
}
