package com.tiktok;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ecommerce_TC_4 extends Base {
    public static void main(String[] args) throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities("TikTokApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

