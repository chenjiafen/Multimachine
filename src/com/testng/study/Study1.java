package com.testng.study;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Study1 {
  @Test(groups="add")
  public void test001_login() {
	  int a=10;
	  int b=20;
	  Assert.assertEquals(30, a+b);
	  System.out.println("TEST");
  }
  @Test(groups="add",priority=5)
  public void test002_set() {
	  float a=10.2f;
	  float b=20.3f;
	  Assert.assertEquals(30.5f, a+b);
	  System.out.println("TEST1");
  }
  @Test(dependsOnGroups="add",groups="sub")
  public void test003() {
	  int a=20;
	  int b=10;
	  Assert.assertEquals(10, a-b);
	  System.out.println("TEST1");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite");
  }

}
