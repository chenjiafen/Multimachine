package com.testfan.testcases.zhihu;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testfan.appium.init.AppiumUtils;
import com.testfan.appium.init.InitDriver;
import com.testfan.appium.init.StartServer;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class ZhihuTestCases {
	
	AndroidDriver<AndroidElement> driver;
	public ZhihuTestCases(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	
	public  void login() throws Exception{
		//by.name这个方法在appium服务端1.5之后就被删除了，我们这里可以用是因为我们修改了服务端的源码
		//对应元素的text属性的值或者content-desc属性的值
		Thread.sleep(5000);
		AndroidElement notLoginBtn=driver.findElement(By.name("未登录"));
		notLoginBtn.click();

		
		//by.id方法的参数值是元素的resource-id属性的值
		AndroidElement otherLogin=driver.findElement(By.id("com.zhihu.android:id/login_other"));
		otherLogin.click();
		
		AndroidElement username=driver.findElementById("com.zhihu.android:id/email_input_view");
		username.sendKeys("yangyangzhuanye@163.com");
		
		AndroidElement pwd=driver.findElementById("com.zhihu.android:id/password");
		pwd.sendKeys("123abc");
		
		//by.className对应的是元素的class属性的值，但是通过class相同的元素在同一个界面会较多，因此该定位方式不常用
		AndroidElement loginBtn=driver.findElement(By.className("android.widget.Button"));
		loginBtn.click();
		
		Thread.sleep(5000);
		//driver.getPageSource(),这个方法表示获取当前界面上所有的资源，返回结果是个字符串
		if(driver.getPageSource().contains("沙陌")){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
	}
	
	public  void logout() throws Exception{
		//driver.findElement(By.name("我的")).click();
		Thread.sleep(5000);
		List<AndroidElement> menus=driver.findElements(By.id("com.zhihu.android:id/tab_title"));
		menus.get(4).click();
		
		AppiumUtils.swipeToUp(driver);
		
		driver.findElement(By.name("设置")).click();
		int i=5;
		while(i>0){
			try {
				driver.findElement(By.name("退出帐号"));
				
				break;
			} catch (Exception e) {
				// TODO: handle exception
				AppiumUtils.swipeToUp(driver);
				i--;
			}
		}
		
		driver.findElement(By.name("退出帐号")).click();
		driver.findElement(By.name("确定")).click();
		
		Thread.sleep(5000);
		//driver.getPageSource()  表示获取当前界面上所有的资源内容
//		if(driver.getPageSource().contains("其他方式登录")){
//			System.out.println("退出成功");
//		}else{
//			System.out.println("退出失败");
//		}
//		try {
//			driver.findElement(By.id("com.zhihu.android:id/login_weibo"));
//			System.out.println("登录成功");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("登录失败");
//		}
		Boolean flag=AppiumUtils.isElementExits(driver, By.id("com.zhihu.android:id/login_weibo"));
		if(flag){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
		
	}
	
	public  void attention() throws Exception{
		clickMenu(0);
		
		List<AndroidElement> articleTitles= driver.findElements(By.id("com.zhihu.android:id/title"));
		
		for(AndroidElement ae:articleTitles){
			String titleText=ae.getText();//表示获取这个元素的text属性的值
			ae.click();
			Thread.sleep(2000);
			if(driver.getPageSource().contains("关注")){
				List<AndroidElement> textViews=driver.findElements(By.className("android.widget.TextView"));
				
				for(AndroidElement ae1:textViews){
					String text=ae1.getText();
					if(text.equals("关注")){
						ae1.click();
						if(driver.getPageSource().contains("已关注")){
							System.out.println(titleText+"：关注成功");
						}else{
							System.out.println(titleText+"：关注失败");
						}
						break;
					}else if(text.equals("已关注")){
						ae1.click();
						driver.findElement(By.name("取消关注")).click();
						if(driver.getPageSource().contains("关注")&&!driver.getPageSource().contains("已关注")){
							System.out.println(titleText+"：取消关注成功");
						}else{
							System.out.println(titleText+"：取消关注失败");
						}
						break;
					}
				}
			}
				driver.pressKeyCode(AndroidKeyCode.BACK);//物理按键的返回
				Thread.sleep(2000);
		}
		
		
	}
	/**
	 * 知乎设置中全局推送通知设置的复选框勾选或不勾选
	 * @throws Exception 
	 */
	public void messageSettings() throws Exception{
		Thread.sleep(5000);
		clickMenuByXpath(5);
		int i=5;
		while(i>0){
			if(AppiumUtils.isElementExits(driver, By.xpath("//*[@text='设置']"))){
				driver.findElement(By.xpath("//*[@text='设置']")).click();
				break;
			}else{
				AppiumUtils.swipeToUp(driver);
				i--;
			}
		}
		
		i=5;
		while(i>0){
			if(AppiumUtils.isElementExits(driver, By.xpath("//*[@text='全局推送通知设置']"))){
				driver.findElement(By.xpath("//*[@text='全局推送通知设置']")).click();
				break;
			}else{
				AppiumUtils.swipeToUp(driver);
				i--;
			}
		}
		
		//*[@resource-id='android:id/checkbox']/../preceding-sibling::*/*[1]
		List<AndroidElement> settings=driver.findElements(By.xpath("//*[@resource-id='android:id/checkbox']/../preceding-sibling::*/*[1]"));
		
		for(AndroidElement ae:settings){
			String text=ae.getText();
			//第一个点击知乎推荐的勾选，xpath是//*[@text='知乎推荐']/../following-sibling::*[1]/*[1]
			AndroidElement checkBox=driver.findElement(By.xpath("//*[@text='"+text+"']/../following-sibling::*[1]/*[1]"));
			String odlStatus=checkBox.getAttribute("checked");
			checkBox.click();
			String newStatus=checkBox.getAttribute("checked");
			if(odlStatus.equals("true")){
				if(newStatus.equals("false")){
					System.out.println(text+"========>取消勾选成功");
				}else{
					System.out.println(text+"========>取消勾选失败");
				}
			}else{
				if(newStatus.equals("true")){
					System.out.println(text+"========>勾选成功");
				}else{
					System.out.println(text+"========>勾选失败");
				}
			}
//			如果只做勾选用下面这段
//			if(odlStatus.equals("false")){
//				checkBox.click();
//				String newStatus=checkBox.getAttribute("checked");
//				if(newStatus.equals("true")){
//					System.out.println(text+"========>勾选成功");
//				}else{
//					System.out.println(text+"========>勾选失败");
//				}
//			}
		}

		
	}
	public void clickLastTitle(){
		clickMenuByXpath(1);
		AndroidElement titleLast=driver.findElement(By.xpath("(//*[@resource-id='com.zhihu.android:id/title'])[last()]"));
		
		AndroidElement menuMain=driver.findElement(By.xpath("//*[@resource-id='com.zhihu.android:id/main_tab_container']"));
		if(AppiumUtils.elementIsOcclusion(titleLast, menuMain, "down")){
			AppiumUtils.swipeToUp(driver);
		}
		titleLast.click();
	}
	
	public void LoginWithPhone(){
		//对应元素的text属性的值或者content-desc属性的值
//		AndroidElement notLoginBtn=driver.findElement(By.xpath("//*[@text='未登录']"));
//		notLoginBtn.click();
		clickMenuByXpath(5);

		
		//by.id方法的参数值是元素的resource-id属性的值
		AndroidElement otherLogin=driver.findElement(By.id("com.zhihu.android:id/login_other"));
		otherLogin.click();
		driver.findElement(By.xpath("//*[@text='免密码登录']")).click();
		
		AndroidElement phone=driver.findElement(By.xpath("//*[@resource-id='com.zhihu.android:id/edit_text']"));
		TouchAction ta=new TouchAction(driver);
		ta.tap(phone.getCenter().getX(), phone.getCenter().getY()).release().perform();
		//18729399607
		AppiumUtils.sendKeyWithNumber(driver, "1829293873");
	}
	
	public  void clickMenu(int index){
		driver.findElements(By.id("com.zhihu.android:id/tab_title")).get(index).click();
	}
	
	public  void clickMenuByXpath(int index){
		//android.widget.HorizontalScrollView/*/*[3]
		driver.findElement(By.xpath("//android.widget.HorizontalScrollView/*/*["+index+"]")).click();
	//	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"登录\")"));
		//显式等待，是针对单独元素的智能等待
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		AndroidElement suibian=(AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("xxxx")));
	}

	public static void main(String[] args) throws Exception {
		//StartServer.startAppium();
//		AndroidDriver<AndroidElement> driver=InitDriver.initDriverWithInstaller("127.0.0.1:62001", "com.zhihu.android", "com.zhihu.android.app.ui.activity.LauncherActivity", "com.zhihu.android.app.ui.activity.MainActivity");
//		//表示在这行代码之后的所有findelement方法都遵循这个等待超时时间
//		//意思是如果没找到元素，那么会在10秒内不断的查找元素，在任意时间点找到元素就结束查找，继续执行后续代码；如果10秒内没找到元素才会报错
//		//仅仅针对查找元素的方法，也就是findelement,其他操作比如输入、点击、滑动之前的等待无效（这种操作之前或之后的等待必须用thread.sleep）
//		//隐式是全局性设置，并且可以随时更改，对更改之后的findelement生效
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Thread.sleep(10000);
//		ZhihuTestCases	zhihu=new ZhihuTestCases(driver);
//		String appPackage=(String) driver.getCapabilities().getCapability("appPackage");
//		String acticity=(String) driver.getCapabilities().getCapability("appActivity");
////		AppiumUtils.startActivity(driver, "com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
////		AppiumUtils.startActivity(driver, appPackage, acticity);
////		zhihu.login();
////		zhihu.logout();
////		zhihu.attention();
////		zhihu.messageSettings();
////		zhihu.LoginWithPhone();
////		System.out.println(driver.getConnection().name());
////		driver.setConnection(Connection.AIRPLANE);//飞行模式
////		driver.resetApp();
//		driver.openNotifications();//打开通知栏，可以测试消息推送
//		driver.launchApp();
//		Thread.sleep(10000);
		
		
		
//		StartServer.stopAppium();

	}

}
