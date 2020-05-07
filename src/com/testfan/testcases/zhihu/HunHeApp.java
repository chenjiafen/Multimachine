package com.testfan.testcases.zhihu;

import java.util.Set;

import org.openqa.selenium.By;

import com.testfan.appium.init.InitDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class HunHeApp {
	
	AndroidDriver<AndroidElement> driver;
	public HunHeApp(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	//NATIVE_APP 这是原生界面的context
	//WEBVIEW_com.testfan.ask  这表示是我当前界面的context
	
	//如果你发现你的混合界面在uiautomatorviewer这个工具下能看到界面内所有的元素的信息时候，则表明app的混合界面被强转成原生界面了，此时按照原生的操作方式定位即可
	//这个现象发生在app被appium测试了以后，所以很可能是appium中的某些操作将其强转了
	public void test() throws Exception{

		//碰到混合界面(webview)时需要先切换
		Set<String> contexts=driver.getContextHandles();
		for(String s:contexts){
			System.out.println(s);
		}
		driver.context("WEBVIEW_com.testfan.ask");//切换到webveviw视图
		Thread.sleep(2000);
		driver.findElement(By.linkText("用户登录")).click();
		
		//1. 当需要滑动界面的时候需要先把driver切换到原生上去，因为webview下的driver不支持滑动
		driver.context("NATIVE_APP");//切换回原生
		
		
	}
	public void chunH5() throws Exception{
		driver.get("http://ask.testfan.cn");
		Thread.sleep(2000);
		driver.findElement(By.linkText("用户登录")).click();
	}
	public static void main(String[] args) throws Exception {
		//AndroidDriver<AndroidElement> driver=InitDriver.initDriverWithInstaller("S9B7N17504008582", "com.testfan.ask", "com.testfan.ask.MainActivity");
		AndroidDriver<AndroidElement> driver=InitDriver.initDriverWithH5("S9B7N17504008582");
		HunHeApp ask=new HunHeApp(driver);
		ask.chunH5();
	}

}
