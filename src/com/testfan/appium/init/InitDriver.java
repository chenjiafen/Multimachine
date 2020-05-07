package com.testfan.appium.init;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * ������װ����driver��ʼ���ĸ������
 */
public class InitDriver {
    /**
     * �ṩ��������caps����
     *
     * @param udid
     * @return
     */
    public static DesiredCapabilities getCommonCaps(String udid) {
        DesiredCapabilities caps = new DesiredCapabilities();// Ҫ���ݸ�����˵Ĳ�������
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "���д");// deviceName��ֵ�ڰ�׿�����д�����Գɹ�
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");// Ҫ��������
        caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);// �Ƿ�֧��appium�Դ���unicode���뷨
        caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);// �Ƿ������豸�����뷨
        caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);// �Ƿ���ǩ��app
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);// ��ʾ�����session��ʱʱ�䣬Ĭ����60��
        caps.setCapability(MobileCapabilityType.UDID, udid);// ��ʾҪ���ӵ���һ̨�豸
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        return caps;
    }

    /**
     * ���δ��װ��Ӧ�ý���driver��ʼ������
     *
     * @param udid
     * @param appPath
     * @return
     * @throws Exception
     */
    public static AndroidDriver<AndroidElement> initDriverWithNotInstaller(String udid, String appPath)
            throws Exception {
        File app = new File(appPath);// Ҫ��װ���Ե�app

        DesiredCapabilities caps = getCommonCaps(udid);// Ҫ���ݸ�����˵Ĳ�������
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }

    public static AndroidDriver<AndroidElement> initDriverWithNotInstaller(String udid, String appPath, String appWaitActivity)
            throws Exception {
        File app = new File(appPath);// Ҫ��װ���Ե�app

        DesiredCapabilities caps = getCommonCaps(udid);// Ҫ���ݸ�����˵Ĳ�������
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, appWaitActivity);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }

    /**
     * ����Ѱ�װ��Ӧ�ã���ֱ������Ӧ�ý��в��Եĳ�ʼ��driver����
     *
     * @param udid
     * @param appPackage
     * @param activity
     * @return
     * @throws Exception
     */
    public static AndroidDriver<AndroidElement> initDriverWithInstaller(String udid, String appPackage, String activity) throws Exception {
        DesiredCapabilities caps = getCommonCaps(udid);// Ҫ���ݸ�����˵Ĳ�������

        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activity);
        //��ģʽ�����ٶȿ죬�������toast��Ϣ�����Բ�������֧�ְ�׿5.0����
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //�ò�������������appĬ����Ȩ
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:/Users/LXG/AppData/Roaming/npm/node_modules/appium/node_modules/appium-chromedriver/chromedriver/win/chromedriver2.28.exe");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;

    }

    public static AndroidDriver<AndroidElement> initDriverWithInstaller(String udid, String appPackage, String activity, String appWaitActivity, String port, String systemPort) throws Exception {
        DesiredCapabilities caps = getCommonCaps(udid);// Ҫ���ݸ�����˵Ĳ�������

        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activity);
        caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, appWaitActivity);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);  //appium�������ֻ��Ķ˿�
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + port + "/wd/hub"), caps);
        return driver;

    }

    public static AndroidDriver<AndroidElement> initDriverWithH5(String udid) throws Exception {
        DesiredCapabilities caps = getCommonCaps(udid);// Ҫ���ݸ�����˵Ĳ�������
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(AndroidMobileCapabilityType.NATIVE_WEB_SCREENSHOT, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;

    }

    public static void main(String[] args) throws Exception {
        // initDriver();
        //initDriverWithInstaller();
    }

}
