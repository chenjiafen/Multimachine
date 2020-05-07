package com.testng.study;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testfan.appium.init.AppiumUtils;
import com.testfan.appium.init.InitDriver;
import com.testfan.appium.init.StartServer;
import com.testfan.testcases.zhihu.ZhihuTestCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author ɳİ  qq2879897713
 *
 */
public class ZhihuTests {
	
	AndroidDriver<AndroidElement> driver;
	ZhihuTestCases zhihu;
	StartServer server;
	@Parameters({"port","systemPort","udid","bp"})
	@BeforeClass
	public void init(String port,String systemPort,String udid,String bp) throws Exception{
		server=new StartServer();
		server.startAppium(port,bp);
		driver=InitDriver.initDriverWithInstaller(udid, "com.zhihu.android", "com.zhihu.android.app.ui.activity.LauncherActivity", "com.zhihu.android.app.ui.activity.MainActivity",port,systemPort);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		zhihu=new ZhihuTestCases(driver);
	}

	@Test
	public void test001_login(){
		try {
			zhihu.login();
			Assert.assertEquals(driver.getPageSource().contains("ɳİ"), true, "not contains");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/loginerror.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("login failure -->"+e.getMessage());
		}catch(Error er){
			//er.printStackTrace();
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/loginerror.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("login failure -->"+er.getMessage());
		}
	}
	@Test(dependsOnMethods="test001_login")
	public void test002_settings(){
		try {
			zhihu.messageSettings();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/settingserror.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("login failure -->"+e.getMessage());
		}catch(Error er){
			//er.printStackTrace();
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/settingserror.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("login failure -->"+er.getMessage());
		}
	}
	@Test(dependsOnMethods="test001_login")
	public void test003_logout(){
		try {
			zhihu.logout();
			Assert.assertEquals(AppiumUtils.isElementExits(driver, By.id("com.zhihu.android:id/login_weibo")), (Boolean)true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/logouterror.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("login failure -->"+e.getMessage());
		}catch(Error er){
			//er.printStackTrace();
			File file=driver.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("images/logouterror.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.fail("login failure -->"+er.getMessage());
		}
	}
	@AfterMethod
	public void backHome(){
		String appPackage=(String) driver.getCapabilities().getCapability("appPackage");
		String appActivity=(String) driver.getCapabilities().getCapability("appActivity");
		String appWaitActivity=(String) driver.getCapabilities().getCapability("appWaitActivity");
		AppiumUtils.startActivity(driver, appPackage, appActivity,appWaitActivity);
	}
	@AfterClass
	public void quit(){
		driver.quit();
	}

}
