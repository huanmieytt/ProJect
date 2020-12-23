package com.ytt.factory;

public class Factory {
	
	public Factory() {
		System.out.println("我是Factory的构造方法------");
	}
	public static String valueOf(String value) {
		return value;
		
	}
	
	public static Factory newInstance() {
		return new Factory();
	}

}
