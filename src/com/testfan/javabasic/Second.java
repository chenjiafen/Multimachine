package com.testfan.javabasic;

/**
 * @author ɳİ  qq2879897713
 *
 */
public class Second {
	
	static int  legs=4;//��4����,��̬�����ı������������
	
	String name="shamo";//����ʵ��������Ҳ�ж������,��Ա����
	
	
	public void f(){
		int a,b;//�����ڲ�����ı����оֲ�����
		System.out.println(legs);
		
	}
	public static void testAppiumShamo(){
		
	}
	
	//alt+/ ��eclipseĬ�ϵ��Զ���ȫ����Ŀ�ݼ�
	public static void main(String[] args) {
		
		//static ���������εı������߷������ǿ���ֱ�ӱ�����ã�δ���εı������߷��������õ�ǰ�������е���
		
		int legs=5;
		
		Second s=new Second();//ʵ��������
		
		System.out.println(Second.legs);
		Second.testAppiumShamo();
		
		System.out.println(s.name);
	
		s.f();
		int A=5;
		int a=4;
		
		//System.out.println(a);
	}
	
}
