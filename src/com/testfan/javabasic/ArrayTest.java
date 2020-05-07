package com.testfan.javabasic;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class ArrayTest {
	
	public static void main(String[] args) {
		String[] sArray=new String[3];
		sArray[0]="AAA";
		sArray[1]="BBB";
		sArray[2]="CCC";
		
//		System.out.println(sArray[0]);
//		System.out.println(sArray[1]);
//		System.out.println(sArray[2]);
		
//		for(int i=0;i<sArray.length;i++){
//			System.out.println(sArray[i]);
//		}
		//使用增强for循环
//		for(String s:sArray){
//			System.out.println(s);
//		}
		
		//使用while循环
		int i=0;
		while(i<sArray.length){
			System.out.println(sArray[i]);
			i++;
		}
		
	}

}
