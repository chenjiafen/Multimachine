package com.testfan.javabasic;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class Second {
	
	static int  legs=4;//有4条腿,静态声明的变量叫做类变量
	
	String name="shamo";//叫做实例变量，也叫对象变量,成员变量
	
	
	public void f(){
		int a,b;//方法内部定义的变量叫局部变量
		System.out.println(legs);
		
	}
	public static void testAppiumShamo(){
		
	}
	
	//alt+/ 是eclipse默认的自动补全代码的快捷键
	public static void main(String[] args) {
		
		//static 在类下修饰的变量或者方法，是可以直接被类调用，未修饰的变量或者方法必须用当前类对象进行调用
		
		int legs=5;
		
		Second s=new Second();//实例化对象
		
		System.out.println(Second.legs);
		Second.testAppiumShamo();
		
		System.out.println(s.name);
	
		s.f();
		int A=5;
		int a=4;
		
		//System.out.println(a);
	}
	
}
