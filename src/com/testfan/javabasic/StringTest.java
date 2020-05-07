package com.testfan.javabasic;

/**
 * @author ɳİ  qq2879897713
 *
 */
public class StringTest {
	
	//��Сд��ת��
	public static void strUperOrLower(){
		String str="ABxBDKoieeyG";
		System.out.println(str.toUpperCase());//ת�ɴ�д
		System.out.println(str.toLowerCase());//ת��Сд
	}
	
	public static void search(){
		String str="hello testfan";
		int index=str.indexOf("llp");
		System.out.println(index);
		if(index!=-1){
			System.out.println("�ַ���������ȷ");
		}
		
	}
	
	public static void contains(){
		String str="hello testfan";
		if(str.contains("hello")){
			System.out.println("����hello");
		}else{
			System.out.println("������");
		}
	}
	
	public static void equals(){
		String str="hello testfan";
		if(str.equals("hello testfan")){
			System.out.println("��ͬ");
		}else{
			System.out.println("��ͬ");
		}
		
		if(str.equalsIgnoreCase("heLLO TESTFAN")){
			System.out.println("��ͬ");
		}else{
			System.out.println("��ͬ");
		}
	}
	
	public static void split(){
		String str="large:1080*1920";
		
		String[] str1=str.split(":");//�ָ�����ؽ����һ�����飬{"large","1080*1920"}
		
		String[] str2=str1[1].split("\\*");//{"1080","1920"}
		
		int width=Integer.valueOf(str2[0]);
		int height=Integer.valueOf(str2[1]);
		
		System.out.println("width is "+width+"  ;height is "+height);
		
	}
	
	public static void replace(){
		String str="hello testfan shamo;hello testfan shamo;hello testfan shamo;hello testfan shamo;hello testfan shamo;hello testfan shamo";
		System.out.println(str.replace("shamo", "loulaoshi"));
	}
	
	public static void subString(){
		String str="hello testfan shamo";
		
		System.out.println(str.substring(14));
		
		String str1="large:1080*1920";
		System.out.println(str1.substring(6, 10));
		System.out.println(str1.substring(11));
	}
	
	
	public static void main(String[] args) {
//		strUperOrLower();
//		search();
		split();
		replace();
		subString();
	}

}
