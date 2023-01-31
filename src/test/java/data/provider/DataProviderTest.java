package data.provider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest {
    WebDriver driver;
    //    @BeforeClass
//    public void beforeClass() {
//        System.out.println("before Class");
//    }
//    @AfterClass
//    public void afterClass() {
//        System.out.println("after Class");
//    }
//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("before Test");
//    }
//    @AfterTest
//    public void afterTest() {
//        System.out.println("after Test");
//    }
    @Parameters({"browser", "url"})
    @BeforeMethod
    public void beforeMethod(String browser, String url) {
        if (browser.equals("Chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equals("Firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        }
        driver.get(url);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test(dataProvider = "data-provider", dataProviderClass=DPClass.class)
    public void tc_01(String username, String password) throws InterruptedException {
        WebElement inputUseranme = driver.findElement(By.id("mat-input-3"));
        WebElement inputPassword = driver.findElement(By.id("mat-input-4"));
        WebElement btnSubmit = driver.findElement(By.id("kt_login_signin_submit"));
        inputUseranme.sendKeys(username);
        inputPassword.sendKeys(password);
        btnSubmit.click();
        System.out.println(username);
        System.out.println(password);
        Thread.sleep(3000);
    }
}
