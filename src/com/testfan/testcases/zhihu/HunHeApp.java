package com.testfan.testcases.zhihu;

import java.util.Set;

import org.openqa.selenium.By;

import com.testfan.appium.init.InitDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author ɳİ  qq2879897713
 *
 */
public class HunHeApp {
	
	AndroidDriver<AndroidElement> driver;
	public HunHeApp(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	//NATIVE_APP ����ԭ�������context
	//WEBVIEW_com.testfan.ask  ���ʾ���ҵ�ǰ�����context
	
	//����㷢����Ļ�Ͻ�����uiautomatorviewer����������ܿ������������е�Ԫ�ص���Ϣʱ�������app�Ļ�Ͻ��汻ǿת��ԭ�������ˣ���ʱ����ԭ���Ĳ�����ʽ��λ����
	//�����������app��appium�������Ժ����Ժܿ�����appium�е�ĳЩ��������ǿת��
	public void test() throws Exception{

		//������Ͻ���(webview)ʱ��Ҫ���л�
		Set<String> contexts=driver.getContextHandles();
		for(String s:contexts){
			System.out.println(s);
		}
		driver.context("WEBVIEW_com.testfan.ask");//�л���webveviw��ͼ
		Thread.sleep(2000);
		driver.findElement(By.linkText("�û���¼")).click();
		
		//1. ����Ҫ���������ʱ����Ҫ�Ȱ�driver�л���ԭ����ȥ����Ϊwebview�µ�driver��֧�ֻ���
		driver.context("NATIVE_APP");//�л���ԭ��
		
		
	}
	public void chunH5() throws Exception{
		driver.get("http://ask.testfan.cn");
		Thread.sleep(2000);
		driver.findElement(By.linkText("�û���¼")).click();
	}
	public static void main(String[] args) throws Exception {
		//AndroidDriver<AndroidElement> driver=InitDriver.initDriverWithInstaller("S9B7N17504008582", "com.testfan.ask", "com.testfan.ask.MainActivity");
		AndroidDriver<AndroidElement> driver=InitDriver.initDriverWithH5("S9B7N17504008582");
		HunHeApp ask=new HunHeApp(driver);
		ask.chunH5();
	}

}
