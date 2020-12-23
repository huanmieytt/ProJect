package com.ytt.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ytt.factory.Factory;


public class TestFactory {

	public static void main(String[] args){
		String str = "hello world";
//		获取静态工厂方法
		String value = Factory.valueOf(str);
		System.out.println("从静态工厂中取出String值"+value);
		System.out.println("====================================");
		Factory factory = Factory.newInstance();
//		System.out.println("Factory的静态工厂方法："+factory);
		
		Logger log = Logger.getLogger("一级日志    Factory的静态工厂方法："+factory);
		log.setLevel(Level.FINE);
		log.info("一级日志    Factory的静态工厂方法："+factory);
		
		Logger log2 = Logger.getLogger("log2");
		log2.setLevel(Level.FINER);
		log2.info("server------------日志---------");
	}
	
	
	
}
