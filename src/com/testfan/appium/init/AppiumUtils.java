package com.testfan.appium.init;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class AppiumUtils {

	public static void swipeToUp(AndroidDriver<AndroidElement> driver) {
		// ��ȡ����Ӧ��ռ����Ļ�Ĵ�С�������������ķֱ��ʣ��ȷֱ���С��
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		TouchAction ta = new TouchAction(driver);
		// ���ϻ���
		ta.press(width / 2, height * 7 / 8).waitAction(Duration.ofMillis(1000)).moveTo(width / 2, height / 8).release()
				.perform();
	}

	public static void swipeToDown(AndroidDriver<AndroidElement> driver) {
		// ��ȡ����Ӧ��ռ����Ļ�Ĵ�С�������������ķֱ��ʣ��ȷֱ���С��
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		TouchAction ta = new TouchAction(driver);
		// ���ϻ���
		ta.press(width / 2, height / 8).waitAction(Duration.ofMillis(1000)).moveTo(width / 2, height * 7 / 8).release()
				.perform();
	}

	public static void swipeToLeft(AndroidDriver<AndroidElement> driver) {
		// ��ȡ����Ӧ��ռ����Ļ�Ĵ�С�������������ķֱ��ʣ��ȷֱ���С��
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		TouchAction ta = new TouchAction(driver);
		// ���ϻ���
		ta.press(width * 7 / 8, height / 2).waitAction(Duration.ofMillis(1000)).moveTo(width / 8, height / 2).release()
				.perform();
	}

	public static void swipeToRight(AndroidDriver<AndroidElement> driver) {
		// ��ȡ����Ӧ��ռ����Ļ�Ĵ�С�������������ķֱ��ʣ��ȷֱ���С��
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		TouchAction ta = new TouchAction(driver);
		// ���ϻ���
		ta.press(width / 8, height / 2).waitAction(Duration.ofMillis(1000)).moveTo(width * 7 / 8, height / 2).release()
				.perform();
	}

	public static Boolean isElementExits(AndroidDriver<AndroidElement> driver, By by) {
		try {
			driver.findElement(by);
			System.out.println("Ԫ�ش���");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ԫ�ز�����");
			
		}
		return false;
		
	}

	/**
	 * ��ȡԪ�ؽ������������
	 * 
	 * @param ele
	 * @return
	 */
	public static Point getEndCoordinate(AndroidElement ele) {
		int e1_x = ele.getLocation().getX();// ��ȡԪ�ص���ʼ��x
		int e1_y = ele.getLocation().getY();// ��ȡԪ�ص���ʼ��Y

		int e1_width = ele.getSize().getWidth();// ��ȡԪ�صĿ�
		int el_height = ele.getSize().getHeight();// ��ȡԪ�صĸ�

		int e1_endx = e1_x + e1_width;
		int e1_endy = e1_y + el_height;

		return new Point(e1_endx, e1_endy);
	}

	/**
	 * �ڴ�ֱ�������ж��Ƿ��ڵ�����Y�᷽��Ĵ�С�Ƚ�
	 * ��Ļ�·������ڵ�Ԫ��ele1�Ľ�����Y�����ֵ<=�ڵ�Ԫ��ele2����ʼ��Yֵ����˵��Ԫ��ele1û�б��ڵ�
	 * ��Ļ�Ϸ������ڵ�Ԫ��ele1����ʼ��Y�����ֵ>=�ڵ�Ԫ��ele2�Ľ������Yֵ����˵��Ԫ��ele1û�б��ڵ�
	 * 
	 * @param ele1
	 * @param ele2
	 */
	public static Boolean elementIsOcclusion(AndroidElement ele1, AndroidElement ele2,String direction) {
		int ele1_starty=ele1.getLocation().getY();//���ڵ�Ԫ��ele1����ʼ��Yֵ
		int ele1_endy = getEndCoordinate(ele1).getY();// ���ڵ�Ԫ�صĽ�����Yֵ
		int ele2_starty = ele2.getLocation().getY();// �ڵ�Ԫ��ele2����ʼ��Yֵ
		int ele2_endy=getEndCoordinate(ele2).getY();//�ڵ�Ԫ��ele2�Ľ�����Yֵ
		if(direction.toLowerCase().equals("down")){
			if (ele1_endy <= ele2_starty) {
				return false;
			} else {
				return true;
			}
		}else if(direction.toLowerCase().equals("up")){
			if (ele1_starty >= ele2_endy) {
				return false;
			} else {
				return true;
			}
		}else{
			return true;
		}

	}
	/**
	 * ��senkeys������һ�������ֳ������ʱ����Գ���ʹ�ø÷���
	 * @param number
	 */
	public static void sendKeyWithNumber(AndroidDriver<AndroidElement> driver,String number){
		char[] numChars=number.toCharArray();
		
		for(char c:numChars){
			int cNum=Integer.valueOf(String.valueOf(c));
			switch (cNum) {
			case 0:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_0);
				break;
			case 1:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_1);
				break;
			case 2:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_2);
				break;
			case 3:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
				break;
			case 4:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_4);
				break;
			case 5:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_5);
				break;
			case 6:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_6);
				break;
			case 7:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_7);
				break;
			case 8:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_8);
				break;
			case 9:
				driver.pressKeyCode(AndroidKeyCode.KEYCODE_9);
				break;
			default:
				break;
			}
		}
	}
	public static void elementSwipe(AndroidElement ele,AndroidDriver<AndroidElement> driver,String direction){
		int x=ele.getLocation().getX();//��ʼ��x  0
		int y=ele.getLocation().getY();//��ʼ��y  391
		
		int width=ele.getSize().getWidth();//Ԫ�صĿ�  720/8=90*7=630
		int height=ele.getSize().getHeight();//Ԫ�صĸ� 103
		TouchAction ta=new TouchAction(driver);
		switch (direction.toLowerCase()) {
		case "up":
			ta.press(x+width/2, y+7*height/8).waitAction(Duration.ofMillis(1000)).moveTo(x+width/2, y+height/8).release().perform();
			break;
		case "down":
			ta.press(x+width/2, y+height/8).waitAction(Duration.ofMillis(1000)).moveTo(x+width/2, y+7*height/8).release().perform();
			break;
		case "left":
			//630,442     90,442   2x+width=90
			ta.press(x+7*width/8, y+height/2).waitAction(Duration.ofMillis(1000)).moveTo(x+width/8, y+height/2).release().perform();
			break;
		case "right":
			ta.press(x+width/8, y+height/2).waitAction(Duration.ofMillis(1000)).moveTo(x+7*width/8, y+height/2).release().perform();
			break;

		default:
			break;
		}
		
	}
	//int[] 1258947
	/**
	 * �÷�������������������޷���λ��ÿһ��С���ӵ����ܹ���λ�������������Ԫ�ص�
	 * @param ele
	 * @param driver
	 * @param pwd
	 */
	public static void gesturePwd(AndroidElement ele,AndroidDriver<AndroidElement> driver,int[] pwd){
//		int x=ele.getLocation().getX();
//		int y=ele.getLocation().getY();
//		
//		int w=ele.getSize().getWidth();
//		int h=ele.getSize().getHeight();
		
		List<Point> coordanites=splitElement(ele,3,3);
		//1. ��ѭ������row����ѭ������column
		//��һ��ִ�У�row=0��������ѭ���� column=0:x+1*w/6,  y+h/6
		//                         column=1:x+3*w/6,y+h/6
		//                         column=2:x+5*w/6,y+h/6
		//�ڶ���ִ�У�row=1��������ѭ���� column=0:x+1*w/6,  y+3*h/6
		//                         column=1:x+3*w/6,y+3*h/6
		//                         column=2:x+5*w/6,y+3*h/6
		//������ִ�У�row=2��������ѭ���� column=0:x+1*w/6,  y+5*h/6
		//                         column=1:x+3*w/6,y+5*h/6
		//                         column=2:x+5*w/6,y+5*h/6
		
//		for(int row=0;row<3;row++){
//			for(int column=0;column<3;column++){
//				int point_x=x+((2*column+1)*w)/6;
//				int point_y=y+((2*row+1)*h)/6;
//				coordanites.add(new Point(point_x,point_y));
//			}
//		}
		TouchAction ta=new TouchAction(driver);
		ta.press(coordanites.get(pwd[0]-1).getX(), coordanites.get(pwd[0]-1).getY()).waitAction(Duration.ofMillis(500));
		for(int i=1;i<pwd.length;i++){
			ta.moveTo(coordanites.get(pwd[i]-1).getX()-coordanites.get(pwd[i-1]-1).getX(), coordanites.get(pwd[i]-1).getY()-coordanites.get(pwd[i-1]-1).getY()).waitAction(Duration.ofMillis(500));
		}
		ta.release().perform();
	}
	/**
	 * int[] 1258947
	 * ������Զ�λ�����������ÿһ��С���ӣ�����ʹ������ķ���
	 */
	public static void gesturePwd(List<AndroidElement> samllPwdList,AndroidDriver<AndroidElement> driver,int[] pwd){
		TouchAction ta=new TouchAction(driver);
		ta.press(samllPwdList.get(pwd[0])).waitAction(Duration.ofMillis(500));
		for(int i=1;i<pwd.length;i++){
			ta.moveTo(samllPwdList.get(pwd[i])).waitAction(Duration.ofMillis(500));
		}
		ta.release().perform();
		//ta.tap(300, 400).release().perform();//������Ԫ�����û�а취��λ��
		//�ڶ��־������Ԫ���ܹ���λ��������click��ʱ����Ч���߱�����ʱ���Գ���ʹ��������������������겢���Ǿ������꣬���Ǹ���Ԫ�ػ�ȡԪ�ص��е����꣬Ȼ�󴫵ݸ�tap����
//		AndroidElement a=driver.findElement(By.xpath("xxx"));
//		ta.tap(a.getCenter().getX(),a.getCenter().getY()).release().perform()
		
	}
	//102034
	public static void anquanPwd(AndroidElement ele,AndroidDriver<AndroidElement> driver,int[] pwd){
//		int x=ele.getLocation().getX();
//		int y=ele.getLocation().getY();
//		
//		int w=ele.getSize().getWidth();
//		int h=ele.getSize().getHeight();
		
		List<Point> coordanites=splitElement(ele,4,4);
		
//		for(int row=0;row<4;row++){
//			for(int column=0;column<4;column++){
//				int point_x=x+((2*column+1)*w)/8;
//				int point_y=y+((2*row+1)*h)/8;
//				coordanites.add(new Point(point_x,point_y));
//			}
//		}
		TouchAction ta=new TouchAction(driver);
		
		for(int i=0;i<pwd.length;i++){
			if(pwd[i]==0){
				ta.press(coordanites.get(13).getX(), coordanites.get(13).getY()).release().perform();
			}else{
				if(pwd[i]<=3){
					ta.press(coordanites.get(pwd[i]-1).getX(), coordanites.get(pwd[i]-1).getY()).release().perform();
				}else if(pwd[i]>=4&&pwd[i]<=6){
					ta.press(coordanites.get(pwd[i]).getX(), coordanites.get(pwd[i]).getY()).release().perform();
				}else if(pwd[i]>=7&&pwd[i]<=9){
					ta.press(coordanites.get(pwd[i]+1).getX(), coordanites.get(pwd[i]+1).getY()).release().perform();
				}
			}
		}
		
		//x����ɶ�Ӧ�ļ��������������ֱ��ǣ�3��7��Ӧ����x��11��15��Ӧ�������
		
	}
	//�������ר��������һ�����Ԫ�ز�ֳɼ��м��е�СԪ�������
	public static List<Point> splitElement(AndroidElement ele,int row,int column){
		int x=ele.getLocation().getX();
		int y=ele.getLocation().getY();
		
		int w=ele.getSize().getWidth();
		int h=ele.getSize().getHeight();
		List<Point> coordanites=new ArrayList<Point>();
		
		for(int r=0;r<row;r++){
			for(int c=0;c<column;c++){
				int point_x=x+((2*c+1)*w)/(2*column);
				int point_y=y+((2*r+1)*h)/(2*row);
				coordanites.add(new Point(point_x,point_y));
			}
		}
		return coordanites;
	}
	
	//ͨ��package��activity�ڲ��Թ�����������app����app����
	public static void startActivity(AndroidDriver<AndroidElement>  driver,String appPackage,String appActivity,String appWaitActivity){
		Activity activity=new Activity(appPackage, appActivity);
		activity.setAppWaitActivity(appWaitActivity);
		driver.startActivity(activity);
	}
}
