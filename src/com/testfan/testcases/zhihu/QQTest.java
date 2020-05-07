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
 * @author ɳİ  qq2879897713
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
//		int x=third.getLocation().getX();//��ʼ��x
//		int y=third.getLocation().getY();//��ʼ��y
//		
//		int width=third.getSize().getWidth();//Ԫ�صĿ�
//		int height=third.getSize().getHeight();//Ԫ�صĸ�
//		
//		TouchAction ta=new TouchAction(driver);
//		ta.press(x+7*width/8, y+height/2).waitAction(Duration.ofMillis(1000)).moveTo(x+width/8, y+height/2).release().perform();
		AppiumUtils.elementSwipe(third, driver, "left");
		//driver.findElement(By.name("ɾ��")).click();
		driver.findElement(MobileBy.AccessibilityId("ɾ��")).click();//�ö�λ����ר��������λcontent-desc�������
		messageList=driver.findElements(By.id("com.tencent.mobileqq:id/relativeItem"));
		int messageCountNew=messageList.size();
		if(messageCount-messageCountNew==1){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
		
	}
	
	public void gesturePwdSet() throws Exception{
		//com.tencent.mobileqq:id/conversation_head
		driver.findElement(By.id("com.tencent.mobileqq:id/conversation_head")).click();
		driver.findElement(By.name("����")).click();
		driver.findElement(By.name("�ʺš��豸��ȫ")).click();
		driver.findElement(By.name("������������")).click();
		driver.findElement(By.name("������������")).click();
		//
		TouchAction ta=new TouchAction(driver);
//		ta.press(210, 525).waitAction(Duration.ofMillis(500)).moveTo(360, 525)
//						  .waitAction(Duration.ofMillis(500)).moveTo(360, 670)
//						  .waitAction(Duration.ofMillis(500)).moveTo(360, 820)
//						  .waitAction(Duration.ofMillis(500)).moveTo(510, 820).release().perform();
		//move to�������д���������ǰһ���������������
		//*[@text='���ƽ���ͼ��']/following-sibling::*[2]
		AndroidElement lock=driver.findElement(By.xpath("//*[@text='���ƽ���ͼ��']/following-sibling::*[2]"));
		int[] pwd={1,2,5,8,9,4,7};
		AppiumUtils.gesturePwd(lock,driver,pwd);
//		int x=lock.getLocation().getX();
//		int y=lock.getLocation().getY();
//		
//		int w=lock.getSize().getWidth();
//		int h=lock.getSize().getHeight();
//		
//		List<Point> coordanites=new ArrayList<Point>();
//		//1. ��ѭ������row����ѭ������column
//		//��һ��ִ�У�row=0��������ѭ���� column=0:x+1*w/6,  y+h/6
//		//                         column=1:x+3*w/6,y+h/6
//		//                         column=2:x+5*w/6,y+h/6
//		//�ڶ���ִ�У�row=1��������ѭ���� column=0:x+1*w/6,  y+3*h/6
//		//                         column=1:x+3*w/6,y+3*h/6
//		//                         column=2:x+5*w/6,y+3*h/6
//		//������ִ�У�row=2��������ѭ���� column=0:x+1*w/6,  y+5*h/6
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
