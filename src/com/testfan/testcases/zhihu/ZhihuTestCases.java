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
 * @author ɳİ  qq2879897713
 *
 */
public class ZhihuTestCases {
	
	AndroidDriver<AndroidElement> driver;
	public ZhihuTestCases(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	
	public  void login() throws Exception{
		//by.name���������appium�����1.5֮��ͱ�ɾ���ˣ������������������Ϊ�����޸��˷���˵�Դ��
		//��ӦԪ�ص�text���Ե�ֵ����content-desc���Ե�ֵ
		Thread.sleep(5000);
		AndroidElement notLoginBtn=driver.findElement(By.name("δ��¼"));
		notLoginBtn.click();

		
		//by.id�����Ĳ���ֵ��Ԫ�ص�resource-id���Ե�ֵ
		AndroidElement otherLogin=driver.findElement(By.id("com.zhihu.android:id/login_other"));
		otherLogin.click();
		
		AndroidElement username=driver.findElementById("com.zhihu.android:id/email_input_view");
		username.sendKeys("yangyangzhuanye@163.com");
		
		AndroidElement pwd=driver.findElementById("com.zhihu.android:id/password");
		pwd.sendKeys("123abc");
		
		//by.className��Ӧ����Ԫ�ص�class���Ե�ֵ������ͨ��class��ͬ��Ԫ����ͬһ�������϶࣬��˸ö�λ��ʽ������
		AndroidElement loginBtn=driver.findElement(By.className("android.widget.Button"));
		loginBtn.click();
		
		Thread.sleep(5000);
		//driver.getPageSource(),���������ʾ��ȡ��ǰ���������е���Դ�����ؽ���Ǹ��ַ���
		if(driver.getPageSource().contains("ɳİ")){
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
		}
	}
	
	public  void logout() throws Exception{
		//driver.findElement(By.name("�ҵ�")).click();
		Thread.sleep(5000);
		List<AndroidElement> menus=driver.findElements(By.id("com.zhihu.android:id/tab_title"));
		menus.get(4).click();
		
		AppiumUtils.swipeToUp(driver);
		
		driver.findElement(By.name("����")).click();
		int i=5;
		while(i>0){
			try {
				driver.findElement(By.name("�˳��ʺ�"));
				
				break;
			} catch (Exception e) {
				// TODO: handle exception
				AppiumUtils.swipeToUp(driver);
				i--;
			}
		}
		
		driver.findElement(By.name("�˳��ʺ�")).click();
		driver.findElement(By.name("ȷ��")).click();
		
		Thread.sleep(5000);
		//driver.getPageSource()  ��ʾ��ȡ��ǰ���������е���Դ����
//		if(driver.getPageSource().contains("������ʽ��¼")){
//			System.out.println("�˳��ɹ�");
//		}else{
//			System.out.println("�˳�ʧ��");
//		}
//		try {
//			driver.findElement(By.id("com.zhihu.android:id/login_weibo"));
//			System.out.println("��¼�ɹ�");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("��¼ʧ��");
//		}
		Boolean flag=AppiumUtils.isElementExits(driver, By.id("com.zhihu.android:id/login_weibo"));
		if(flag){
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
		}
		
	}
	
	public  void attention() throws Exception{
		clickMenu(0);
		
		List<AndroidElement> articleTitles= driver.findElements(By.id("com.zhihu.android:id/title"));
		
		for(AndroidElement ae:articleTitles){
			String titleText=ae.getText();//��ʾ��ȡ���Ԫ�ص�text���Ե�ֵ
			ae.click();
			Thread.sleep(2000);
			if(driver.getPageSource().contains("��ע")){
				List<AndroidElement> textViews=driver.findElements(By.className("android.widget.TextView"));
				
				for(AndroidElement ae1:textViews){
					String text=ae1.getText();
					if(text.equals("��ע")){
						ae1.click();
						if(driver.getPageSource().contains("�ѹ�ע")){
							System.out.println(titleText+"����ע�ɹ�");
						}else{
							System.out.println(titleText+"����עʧ��");
						}
						break;
					}else if(text.equals("�ѹ�ע")){
						ae1.click();
						driver.findElement(By.name("ȡ����ע")).click();
						if(driver.getPageSource().contains("��ע")&&!driver.getPageSource().contains("�ѹ�ע")){
							System.out.println(titleText+"��ȡ����ע�ɹ�");
						}else{
							System.out.println(titleText+"��ȡ����עʧ��");
						}
						break;
					}
				}
			}
				driver.pressKeyCode(AndroidKeyCode.BACK);//�������ķ���
				Thread.sleep(2000);
		}
		
		
	}
	/**
	 * ֪��������ȫ������֪ͨ���õĸ�ѡ��ѡ�򲻹�ѡ
	 * @throws Exception 
	 */
	public void messageSettings() throws Exception{
		Thread.sleep(5000);
		clickMenuByXpath(5);
		int i=5;
		while(i>0){
			if(AppiumUtils.isElementExits(driver, By.xpath("//*[@text='����']"))){
				driver.findElement(By.xpath("//*[@text='����']")).click();
				break;
			}else{
				AppiumUtils.swipeToUp(driver);
				i--;
			}
		}
		
		i=5;
		while(i>0){
			if(AppiumUtils.isElementExits(driver, By.xpath("//*[@text='ȫ������֪ͨ����']"))){
				driver.findElement(By.xpath("//*[@text='ȫ������֪ͨ����']")).click();
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
			//��һ�����֪���Ƽ��Ĺ�ѡ��xpath��//*[@text='֪���Ƽ�']/../following-sibling::*[1]/*[1]
			AndroidElement checkBox=driver.findElement(By.xpath("//*[@text='"+text+"']/../following-sibling::*[1]/*[1]"));
			String odlStatus=checkBox.getAttribute("checked");
			checkBox.click();
			String newStatus=checkBox.getAttribute("checked");
			if(odlStatus.equals("true")){
				if(newStatus.equals("false")){
					System.out.println(text+"========>ȡ����ѡ�ɹ�");
				}else{
					System.out.println(text+"========>ȡ����ѡʧ��");
				}
			}else{
				if(newStatus.equals("true")){
					System.out.println(text+"========>��ѡ�ɹ�");
				}else{
					System.out.println(text+"========>��ѡʧ��");
				}
			}
//			���ֻ����ѡ���������
//			if(odlStatus.equals("false")){
//				checkBox.click();
//				String newStatus=checkBox.getAttribute("checked");
//				if(newStatus.equals("true")){
//					System.out.println(text+"========>��ѡ�ɹ�");
//				}else{
//					System.out.println(text+"========>��ѡʧ��");
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
		//��ӦԪ�ص�text���Ե�ֵ����content-desc���Ե�ֵ
//		AndroidElement notLoginBtn=driver.findElement(By.xpath("//*[@text='δ��¼']"));
//		notLoginBtn.click();
		clickMenuByXpath(5);

		
		//by.id�����Ĳ���ֵ��Ԫ�ص�resource-id���Ե�ֵ
		AndroidElement otherLogin=driver.findElement(By.id("com.zhihu.android:id/login_other"));
		otherLogin.click();
		driver.findElement(By.xpath("//*[@text='�������¼']")).click();
		
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
	//	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"��¼\")"));
		//��ʽ�ȴ�������Ե���Ԫ�ص����ܵȴ�
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		AndroidElement suibian=(AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("xxxx")));
	}

	public static void main(String[] args) throws Exception {
		//StartServer.startAppium();
//		AndroidDriver<AndroidElement> driver=InitDriver.initDriverWithInstaller("127.0.0.1:62001", "com.zhihu.android", "com.zhihu.android.app.ui.activity.LauncherActivity", "com.zhihu.android.app.ui.activity.MainActivity");
//		//��ʾ�����д���֮�������findelement��������ѭ����ȴ���ʱʱ��
//		//��˼�����û�ҵ�Ԫ�أ���ô����10���ڲ��ϵĲ���Ԫ�أ�������ʱ����ҵ�Ԫ�ؾͽ������ң�����ִ�к������룻���10����û�ҵ�Ԫ�زŻᱨ��
//		//������Բ���Ԫ�صķ�����Ҳ����findelement,���������������롢���������֮ǰ�ĵȴ���Ч�����ֲ���֮ǰ��֮��ĵȴ�������thread.sleep��
//		//��ʽ��ȫ�������ã����ҿ�����ʱ���ģ��Ը���֮���findelement��Ч
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
////		driver.setConnection(Connection.AIRPLANE);//����ģʽ
////		driver.resetApp();
//		driver.openNotifications();//��֪ͨ�������Բ�����Ϣ����
//		driver.launchApp();
//		Thread.sleep(10000);
		
		
		
//		StartServer.stopAppium();

	}

}
