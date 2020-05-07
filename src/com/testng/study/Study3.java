package com.testng.study;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Study3 {
  @Test
  public void test006_f222() {
  }
  @Parameters({"name","age"})
  @Test(priority=2)
  public void f333(String username,String age) {
	  System.out.println(username+"ƒÍ¡‰ «£∫"+age);
  }
  
  
  @Test(enabled=false)
  public void f111() {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
