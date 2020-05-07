package com.testng.study;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author É³Ä°  qq2879897713
 *
 */
public class Study4 {
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] obj={{"001","A"},
						{"002","B"},
						{"003","C"}
					   };
		return obj;
	}
	
	@DataProvider
	public Object[][] getData1(){
		
		Object[][] obj={
						{"username1","pwd1","assert1"},
						{"username2","pwd2","assert2"},
						{"username3","pwd3","assert3"}
					   };
		return obj;
	}
	
	@Test(dataProvider="getData")
	public void test(String num,String chr){
		System.out.println(num+":"+chr);
	}
	
	@Test(dataProvider="getData1")
	public void login(String username,String pwd,String assertValue){
		System.out.println(username+":"+pwd);
		Assert.assertEquals("assertValue", assertValue);
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("ÖØÆôapp");
	}

}
