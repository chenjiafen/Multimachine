package com.testfan.javabasic;

/**
 * @author ɳİ  qq2879897713
 *
 */
public class MethodCreate {
	
	//û����static���Σ���������һ�����󷽷�����ʵ������������ʹ�ö������ʵ�������ø÷���
	public void add(){
		int a=10;
		int b=20;
		int sum=a+b;
		System.out.println(sum);
	}
	
	//����ķ����Ľ���Ǳ�����Ҫ��ʱ����ô��������Ϳ��Զ�����з���ֵ�ķ���������ķ����Ľ�����Ǳ�����Ҫ�ģ���ô�Ϳ��Զ���ɲ���Ҫ����ֵ��
	public int add(int a,int b){
		//System.out.println(a+b);
		return a+b;
	}
	
	public int add(int a,int b,int c){
		//System.out.println(a+b);
		return a+b+c;
	}
	//��һ�����£�����������ͬ�����ǲ������Ͳ�ͬ���߲���������ͬ�����ǰ�����չ����ʽ��������(��̬��һ�ֱ�����ʽ)
	public String add(String s1,String s2){
		//System.out.println(a+b);
		return s1+s2;
	}
	
	//���������������ַ������ӣ������ؽ��
	public String strAdd(String s1,String s2){
		String s=s1+s2;
		return s;
	}
	
	public Second sec(){
		Second sc=new Second();
		return sc;
	}
	
	//��static���εķ�����һ���෽�����෽������ʹ������ֱ�ӵ���
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
