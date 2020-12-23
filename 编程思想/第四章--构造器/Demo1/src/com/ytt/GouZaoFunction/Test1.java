package com.ytt.GouZaoFunction;


class Fun {
//	Fun(){
//		System.out.println("------innitial fun() º¯Êý-------");
//	}
	
	Fun(int i){
		System.out.println("------innitial fun() º¯Êý-------" + i);
	}
}
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i = 1;i<=10;i++) {
//			System.out.print(new Fun());
//			System.out.println("  "+i);
//			
//		}
		for(int i = 0;i<=10;i++)
		{
			System.out.println(new Fun(i));
		}
	}

}
