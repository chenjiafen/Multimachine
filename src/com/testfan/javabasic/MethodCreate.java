package com.testfan.javabasic;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class MethodCreate {
	
	//没有用static修饰，所以这是一个对象方法或者实例方法，必须使用对象或者实例来调用该方法
	public void add(){
		int a=10;
		int b=20;
		int sum=a+b;
		System.out.println(sum);
	}
	
	//当你的方法的结果是别人需要的时候，那么这个方法就可以定义成有返回值的方法；当你的方法的结果不是别人需要的，那么就可以定义成不需要返回值的
	public int add(int a,int b){
		//System.out.println(a+b);
		return a+b;
	}
	
	public int add(int a,int b,int c){
		//System.out.println(a+b);
		return a+b+c;
	}
	//在一个类下，方法名称相同，但是参数类型不同或者参数个数不同，我们把这种展现形式叫做重载(多态的一种表现形式)
	public String add(String s1,String s2){
		//System.out.println(a+b);
		return s1+s2;
	}
	
	//这个方法用来完成字符串连接，并返回结果
	public String strAdd(String s1,String s2){
		String s=s1+s2;
		return s;
	}
	
	public Second sec(){
		Second sc=new Second();
		return sc;
	}
	
	//有static修饰的方法是一个类方法，类方法可以使用类名直接调用
	public static void sub(){
		int a=20;
		int b=10;
		int sub=a-b;
		System.out.println(sub);
	}

	public static void main(String[] args) {
		MethodCreate mc=new MethodCreate();
		//mc.add();
		//MethodCreate.sub();
		
		int sum=mc.add(2, 3);
		System.out.println(sum);
		int sum1=mc.add(1, 2, 3);
		String s=mc.add("A", "BC");
	}

}
