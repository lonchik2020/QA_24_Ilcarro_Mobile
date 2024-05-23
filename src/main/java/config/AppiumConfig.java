package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {
    //  "platformName": "Android",
//            "deviceName": "Nexus6",
//            "platformVersion": "8.0",
//            "appPackage": "com.telran.ilcarro",
//            "appActivity": ".SplashActivity"
    public static AppiumDriver<MobileElement>driver;

    @BeforeSuite
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("deviceName","Nexus6");
        desiredCapabilities.setCapability("platformVersion","8.0");
        desiredCapabilities.setCapability("appPackage", "com.telran.ilcarro");
        desiredCapabilities.setCapability("appActivity",".SplashActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        try {
            driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);//address to appium server
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}


