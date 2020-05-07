package com.testfan.javabasic;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class Animal {
	
	String name;
	int age;
	
	//每个类都必须有一个构造方法，构造方法是用来做对象实例化的初始化操作，如果不写会默认有一个空的构造方法
	public Animal(){
		System.out.println("这是一个空的构造方法");
	}
	
	public Animal(String name){
		this.name=name;
		System.out.println(this.name);
	}
	
	public Animal(int age){
		this.age=age;
		System.out.println(this.age);
	}
	
	public void print(){
		System.out.println(this.name);
	}
	
	public static void main(String[] args) {
		Animal a=new Animal("小狗旺财");
		Animal b=new Animal(18);
	}

}
