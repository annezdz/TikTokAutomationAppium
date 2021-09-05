package com.tiktok;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Base {
    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {

        String projectPath = System.getProperty("user.dir");
        DesiredCapabilities cap = new DesiredCapabilities();

        FileInputStream fis = new FileInputStream(projectPath + "\\src\\global.properties");

        Properties prop = new Properties();

        prop.load(fis);

        File apk = new File (prop.getProperty("TikTokApp"));
        String device = (String) prop.get("device");

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        cap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        return driver;
    }
}