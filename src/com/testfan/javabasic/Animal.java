package com.testfan.javabasic;

/**
 * @author ɳİ  qq2879897713
 *
 */
public class Animal {
	
	String name;
	int age;
	
	//ÿ���඼������һ�����췽�������췽��������������ʵ�����ĳ�ʼ�������������д��Ĭ����һ���յĹ��췽��
	public Animal(){
		System.out.println("����һ���յĹ��췽��");
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
		Animal a=new Animal("С������");
		Animal b=new Animal(18);
	}

}
