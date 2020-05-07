package com.testfan.javabasic;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class Method1 extends MethodCreate {
	
	public int add(int a,int b,int c,int d){
		return a+b+c+d;
	}
	
	//和父类方法名称相同参数相同，但是我需要重写才能满足我的业务需求，这种我们脚本重写（多态的另一种表现形式）
	public String strAdd(String s1,String s2){
		return s1+s2+"method1";
	}
	
	public static void main(String[] args) {
		Method1 m1=new Method1();
		int sum=m1.add(2, 3);
		System.out.println(m1.strAdd("A", "B"));
	}
}
