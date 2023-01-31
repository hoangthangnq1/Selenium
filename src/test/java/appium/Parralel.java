package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Parralel {
    protected AndroidDriver<MobileElement> driver;
    @BeforeClass
    public void setUp1() throws MalformedURLException {
        DesiredCapabilities cap1 = new DesiredCapabilities();
        cap1.setCapability("uid", "289dd2370506");
        cap1.setCapability("platformName", "Android");
        cap1.setCapability("appPackage", "vn.frt.app.delivery.uat");
        cap1.setCapability("appActivity", "vn.frt.app.delivery.MainActivity");
//        cap1.setCapability("automationName", "UiAutomator2");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, cap1);
    }

    @Test
    public void test() throws InterruptedException, MalformedURLException {
        Thread.sleep(3000);
        System.out.println("open App LCD");
        MobileElement inputUser = driver.findElement(By.xpath("//*[contains(@text,'Mã nhân viên')]"));
//        MobileElement mobileElement = (MobileElement)inputUser;
        inputUser.click();
        inputUser.sendKeys("00488");


        ((AndroidDriver) driver).startActivity(new Activity("vn.frt.app.rsa.uat", "vn.frt.app.rsa.MainActivity"));
//        inputUser.sendKeys("00488");
        Thread.sleep(3000);
        inputUser.click();
        inputUser.sendKeys("00488");
        System.out.println("open App RSA");
    }

    @AfterClass
    public void tearDown() {
        driver.closeApp();
    }
}
