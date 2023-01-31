package extentreports;

import Listener.BaseTest;
import Listener.ReportListener;
import Screenshot.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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

    @Test(priority = 2) //Failed Test
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
