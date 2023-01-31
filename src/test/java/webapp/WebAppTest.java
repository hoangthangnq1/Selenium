package webapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WebAppTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setCapability("deviceName", "Nexus5");
            cap.setCapability("uid", "289dd2370506");
            cap.setCapability("platformName", "Android");
            cap.setCapability("automationName", "UiAutomator2");
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            cap.setCapability(MobileCapabilityType.VERSION, "5.1");

            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testOne() throws InterruptedException {
//        driver.get("https://www.amazon.com/");
//        Thread.sleep(1000);
//        WebElement search = driver.findElement(By.id("nav-search-keywords"));
//        search.sendKeys("Laptop");
//        Thread.sleep(3000);
        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.className("gLFyf"));
        search.sendKeys("Laptop");
        Thread.sleep(3000);
    }
}
