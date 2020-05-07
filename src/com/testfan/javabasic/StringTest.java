package com.testfan.javabasic;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class StringTest {
	
	//大小写的转换
	public static void strUperOrLower(){
		String str="ABxBDKoieeyG";
		System.out.println(str.toUpperCase());//转成大写
		System.out.println(str.toLowerCase());//转成小写
	}
	
	public static void search(){
		String str="hello testfan";
		int index=str.indexOf("llp");
		System.out.println(index);
		if(index!=-1){
			System.out.println("字符串查找正确");
		}
		
	}
	
	public static void contains(){
		String str="hello testfan";
		if(str.contains("hello")){
			System.out.println("包含hello");
		}else{
			System.out.println("不包含");
		}
	}
	
	public static void equals(){
		String str="hello testfan";
		if(str.equals("hello testfan")){
			System.out.println("相同");
		}else{
			System.out.println("不同");
		}
		
		if(str.equalsIgnoreCase("heLLO TESTFAN")){
			System.out.println("相同");
		}else{
			System.out.println("不同");
		}
	}
	
	public static void split(){
		String str="large:1080*1920";
		
		String[] str1=str.split(":");//分割方法返回结果是一个数组，{"large","1080*1920"}
		
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
