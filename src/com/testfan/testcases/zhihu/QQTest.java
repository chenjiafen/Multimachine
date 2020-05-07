package com.testfan.testcases.zhihu;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import com.testfan.appium.init.AppiumUtils;
import com.testfan.appium.init.InitDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author 沙陌  qq2879897713
 *
 */
public class QQTest {
	
	AndroidDriver<AndroidElement> driver;
	public QQTest(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	
	public void deleteMessage(){
		List<AndroidElement> messageList=driver.findElements(By.id("com.tencent.mobileqq:id/relativeItem"));
		int messageCount=messageList.size();
		AndroidElement third=messageList.get(2);
//		int x=third.getLocation().getX();//起始点x
//		int y=third.getLocation().getY();//起始点y
//		
//		int width=third.getSize().getWidth();//元素的宽
//		int height=third.getSize().getHeight();//元素的高
//		
//		TouchAction ta=new TouchAction(driver);
//		ta.press(x+7*width/8, y+height/2).waitAction(Duration.ofMillis(1000)).moveTo(x+width/8, y+height/2).release().perform();
		AppiumUtils.elementSwipe(third, driver, "left");
		//driver.findElement(By.name("删除")).click();
		driver.findElement(MobileBy.AccessibilityId("删除")).click();//该定位方法专门用来定位content-desc这个属性
		messageList=driver.findElements(By.id("com.tencent.mobileqq:id/relativeItem"));
		int messageCountNew=messageList.size();
		if(messageCount-messageCountNew==1){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		
	}
	
	public void gesturePwdSet() throws Exception{
		//com.tencent.mobileqq:id/conversation_head
		driver.findElement(By.id("com.tencent.mobileqq:id/conversation_head")).click();
		driver.findElement(By.name("设置")).click();
		driver.findElement(By.name("帐号、设备安全")).click();
		driver.findElement(By.name("手势密码锁定")).click();
		driver.findElement(By.name("创建手势密码")).click();
		//
		TouchAction ta=new TouchAction(driver);
//		ta.press(210, 525).waitAction(Duration.ofMillis(500)).moveTo(360, 525)
//						  .waitAction(Duration.ofMillis(500)).moveTo(360, 670)
//						  .waitAction(Duration.ofMillis(500)).moveTo(360, 820)
//						  .waitAction(Duration.ofMillis(500)).moveTo(510, 820).release().perform();
		//move to里的数字写的是相对于前一个坐标点的相对坐标
		//*[@text='绘制解锁图案']/following-sibling::*[2]
		AndroidElement lock=driver.findElement(By.xpath("//*[@text='绘制解锁图案']/following-sibling::*[2]"));
		int[] pwd={1,2,5,8,9,4,7};
		AppiumUtils.gesturePwd(lock,driver,pwd);
//		int x=lock.getLocation().getX();
//		int y=lock.getLocation().getY();
//		
//		int w=lock.getSize().getWidth();
//		int h=lock.getSize().getHeight();
//		
//		List<Point> coordanites=new ArrayList<Point>();
//		//1. 外循环是行row，内循环是列column
//		//第一次执行，row=0，进入内循环， column=0:x+1*w/6,  y+h/6
//		//                         column=1:x+3*w/6,y+h/6
//		//                         column=2:x+5*w/6,y+h/6
//		//第二次执行，row=1，进入内循环， column=0:x+1*w/6,  y+3*h/6
//		//                         column=1:x+3*w/6,y+3*h/6
//		//                         column=2:x+5*w/6,y+3*h/6
//		//第三次执行，row=2，进入内循环， column=0:x+1*w/6,  y+5*h/6
//		//                         column=1:x+3*w/6,y+5*h/6
//		//                         column=2:x+5*w/6,y+5*h/6
//		
//		for(int row=0;row<3;row++){
//			for(int column=0;column<3;column++){
//				int point_x=x+((2*column+1)*w)/6;
//				int point_y=y+((2*row+1)*h)/6;
//				coordanites.add(new Point(point_x,point_y));
//			}
//		}
//		ta.press(coordanites.get(0).getX(), coordanites.get(0).getY())
//		  .waitAction(Duration.ofMillis(500)).moveTo(coordanites.get(1).getX()-coordanites.get(0).getX(), coordanites.get(1).getY()-coordanites.get(0).getY())
//		  .waitAction(Duration.ofMillis(500)).moveTo(coordanites.get(4).getX()-coordanites.get(1).getX(), coordanites.get(4).getY()-coordanites.get(1).getY())
//		  .waitAction(Duration.ofMillis(500)).moveTo(coordanites.get(7).getX()-coordanites.get(4).getX(), coordanites.get(7).getY()-coordanites.get(4).getY())
//		  .waitAction(Duration.ofMillis(500)).moveTo(coordanites.get(8).getX()-coordanites.get(7).getX(), coordanites.get(8).getY()-coordanites.get(7).getY()).release().perform();
//		Thread.sleep(1000);
//		
//		
////		ta.press(x+w/6, y+h/6).waitAction(Duration.ofMillis(500)).moveTo(2*w/6, 0)
////		  .waitAction(Duration.ofMillis(500)).moveTo(0, 2*h/6)
////		  .waitAction(Duration.ofMillis(500)).moveTo(0, 2*h/6)
////		  .waitAction(Duration.ofMillis(500)).moveTo(2*w/6, 0).release().perform();
////		Thread.sleep(1000);
////		ta.press(x+w/6, y+h/6).waitAction(Duration.ofMillis(500)).moveTo(2*w/6, 0)
////		  .waitAction(Duration.ofMillis(500)).moveTo(0, 2*h/6)
////		  .waitAction(Duration.ofMillis(500)).moveTo(0, 2*h/6)
////		  .waitAction(Duration.ofMillis(500)).moveTo(2*w/6, 0).release().perform();
//		
//		
////		ta.press(210, 525).waitAction(Duration.ofMillis(500)).moveTo(150, 0)
////		  .waitAction(Duration.ofMillis(500)).moveTo(0, 150)
////		  .waitAction(Duration.ofMillis(500)).moveTo(0, 150)
////		  .waitAction(Duration.ofMillis(500)).moveTo(150, 0).release().perform();
////		Thread.sleep(1000);
////		ta.press(210, 525).waitAction(Duration.ofMillis(500)).moveTo(150, 0)
////		  .waitAction(Duration.ofMillis(500)).moveTo(0, 150)
////		  .waitAction(Duration.ofMillis(500)).moveTo(0, 150)
////		  .waitAction(Duration.ofMillis(500)).moveTo(150, 0).release().perform();
		
	}
	public static void main(String[] args) throws Exception {
		AndroidDriver<AndroidElement> driver=InitDriver.initDriverWithInstaller("S9B7N17504008582", "com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
		Thread.sleep(5000);
		QQTest qq=new QQTest(driver);
		qq.gesturePwdSet();
		Thread.sleep(10000);
	}

}
