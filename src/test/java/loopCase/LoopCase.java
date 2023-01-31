package loopCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoopCase {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://uat-rsa-ecom.frt.vn");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test(invocationCount = 1, threadPoolSize = 1)
    public void tc_01() throws InterruptedException {
        WebElement inputUsername = driver.findElement(By.id("mat-input-3"));
        WebElement inputPassword = driver.findElement(By.id("mat-input-4"));
        WebElement btnSubmit = driver.findElement(By.id("kt_login_signin_submit"));
        inputUsername.sendKeys("42109");
        inputPassword.sendKeys("ádfasfsafasf");
        btnSubmit.click();
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = { "tc_01" })
    public void tc_02() throws InterruptedException {
        WebElement inputUsername = driver.findElement(By.id("mat-input-3"));
        WebElement inputPassword = driver.findElement(By.id("mat-input-4"));
        WebElement btnSubmit = driver.findElement(By.id("kt_login_signin_submit"));
        inputUsername.sendKeys("42108");
        inputPassword.sendKeys("ádfasfsafasf");
        btnSubmit.click();
        Thread.sleep(3000);
    }
}
