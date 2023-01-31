package Listener;

import Screenshot.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.SkipException;

@Listeners(ReportListener.class)
public class ListenerTC extends BaseTest {

    WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        PropertiesFile.setPropertiesFile();
        driver = getDriver();
    }

    @Test(priority = 1) //Success Test
    public void TC_Done() throws InterruptedException {
        WebElement inputUseranme = driver.findElement(By.id("mat-input-3"));
        WebElement inputPassword = driver.findElement(By.id("mat-input-4"));
        WebElement btnSubmit = driver.findElement(By.id("kt_login_signin_submit"));
        inputUseranme.sendKeys("42109");
        inputPassword.sendKeys("1312313123");
        btnSubmit.click();
        Thread.sleep(3000);
    }

    @Test(priority = 2, description = "Test case này sẽ failed") //Failed Test
    public void TC_Failed() {
        WebElement inputUseranme = driver.findElement(By.id("mat-input-3"));
        WebElement inputPassword = driver.findElement(By.id("mat-input-22313"));
        WebElement btnSubmit = driver.findElement(By.id("kt_login_signin_submit"));
        inputUseranme.sendKeys("42109");
        inputPassword.sendKeys("1312313123");
        btnSubmit.click();
    }

    @Test(priority = 3)  //Skip Test
    public void TC_Skip() {
        throw new SkipException("Skipping The Test Method ");
    }
}
