package com.testfan.javabasic;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class HashMapTest {
	
	//{"username":"shamo","age":"18","job":"tester"},key value类型的数据
	
	
	public static void main(String[] args) {
		HashMap<String, String> map=new HashMap<String,String>();
		
		map.put("username", "shamo");
		map.put("age", "18");
		map.put("job", "tester");
		
		System.out.println(map.size());
		
		System.out.println(map.get("username"));
		
		if(map.containsKey("username")){
			
		}
		if(map.containsValue("shamo")){
			
		}
		
		map.replace("username", "loulaoshi");
		System.out.println(map.get("username"));
//		map.remove("username");
//		if(map.containsKey("username")){
//			
//		}else{
//			System.out.println("没有username");
//		}
		
		//第一种 遍历值
		Collection c1=map.values();
		Iterator it1=c1.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		
		//第二种遍历 key 和 value
		
		Iterator it2=map.entrySet().iterator();
		while(it2.hasNext()){
			Entry entry=(Entry) it2.next();
			Object key=entry.getKey();
			Object value=entry.getValue();
			System.out.println(key.toString()+":"+value.toString());
		}
		
		//第三种 通过key遍历value
		Iterator it3=map.keySet().iterator();
		while(it3.hasNext()){
			String key=(String) it3.next();
			String value=map.get(key);
			System.out.println(key+":"+value);
		}
		
		
	}

}
