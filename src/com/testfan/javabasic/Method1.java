package com.testfan.javabasic;

/**
 * @author ɳİ  qq2879897713
 *
 */
public class Method1 extends MethodCreate {
	
	public int add(int a,int b,int c,int d){
		return a+b+c+d;
	}
	
	//�͸��෽��������ͬ������ͬ����������Ҫ��д���������ҵ�ҵ�������������ǽű���д����̬����һ�ֱ�����ʽ��
	public String strAdd(String s1,String s2){
		return s1+s2+"method1";
	}
	
	public static void main(String[] args) {
		Method1 m1=new Method1();
		int sum=m1.add(2, 3);
		System.out.println(m1.strAdd("A", "B"));
	}
}
