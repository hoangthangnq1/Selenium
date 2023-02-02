package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setCapability("deviceName", "Nexus5");
            cap.setCapability("uid", "289dd2370506");
            cap.setCapability("platformName", "Android");
            cap.setCapability("appPackage", "vn.frt.app.delivery.uat");
            cap.setCapability("appActivity", "vn.frt.app.delivery.MainActivity");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(url, cap);
//             wait = new WebDriverWait(driver,30);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOne() {
        System.out.println("ok");
        MobileElement user = driver.findElement(By.xpath("//*[contains(@text,'Mã nhân viên')]"));
        MobileElement pass = driver.findElement(By.xpath("//*[contains(@text,'Mật khẩu')]"));
        MobileElement btnLogin = driver.findElement(By.xpath("//*[@content-desc='Đăng nhập']"));
        MobileElement phancong = driver.findElement(By.xpath("//*[contains(@content-desc,'Phân công')]"));
        user.click();
        user.sendKeys("42365");
        pass.click();
        pass.sendKeys("23131231312");
        btnLogin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Phân công')]")));
        phancong.click();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
