package com.testng.study;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author É³Ä°  qq2879897713
 *
 */
public class Study2 {
	
	@BeforeClass
	public void initDriver(){
		
	}
	
	
	@Test(priority=1)
	public void test004_login(){
		System.out.println("study2");
		//Assert.fail("Ç¿ÖÆÊ§°Ü");
	}
	
	@Test(dependsOnMethods="test004_login")
	public void test005_settings(){
		System.out.println("settings");
	}
	
	@Test
	public void add(){
		int a=10;
		int b=20;
		int sum=a+b;
		Assert.assertEquals(sum, 31);
		
	}
	
	@AfterClass
	public void quit(){
		
	}

}
