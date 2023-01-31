package appium;

import data.provider.DPClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Scroll {
    protected AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setCapability("deviceName", "Nexus5");
            cap.setCapability("uid", "289dd2370506");
            cap.setCapability("platformName", "Android");
            cap.setCapability("appPackage", "vn.frt.app.delivery.uat");
            cap.setCapability("appActivity", "vn.frt.app.delivery.MainActivity");
            cap.setCapability("automationName", "UiAutomator2");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(url, cap);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testOne() {
        MobileElement two = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        two.click();
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        plus.click();
        MobileElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        three.click();
        MobileElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));
        equals.click();
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        System.out.println("Result testOne: " + result.getText());
    }
}
