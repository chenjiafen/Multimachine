package com.testfan.javabasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author É³Ä°  qq2879897713
 *
 */
public class ListTest {
	
	public static void main(String[] args) {
		List<String> list1=new ArrayList<String>();
		
		System.out.println(list1.size());
		list1.add("AA");
		list1.add("BB");
		list1.add("cc");
		System.out.println(list1.size());
		System.out.println(list1.get(0));
		list1.remove(2);
		System.out.println(list1.size());
		if(list1.contains("AA")){
			System.out.println("ÊÇ");
		}
//		
//		for(String s:list1){
//			System.out.println(s);
//		}
//		
//		for(int i=0;i<list1.size();i++){
//			System.out.println(list1.get(i));
//		}
//		String[] listStrs=list1.toArray(new String[0]);
//		
//		
//		List objList=new ArrayList();
//		objList.add(new Animal());
//		objList.add(new Second());
//		objList.add("cc");
//		objList.add(1);
		
		ArrayList<Animal> animal=new ArrayList<Animal>();
		animal.add(new Animal());
		animal.add(new Animal(12));
		animal.add(new Animal("xxx"));
		
		for(Animal a:animal){
			a.print();
		}
		
		
	}

}
