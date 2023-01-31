import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class test {
    WebDriver driver;
    WebDriverWait wait;
        @BeforeTest
        public void setUpTest(){
            driver = WebDriverManager.firefoxdriver().create();
            wait = new WebDriverWait(driver,10);
        }
        @AfterTest
        public void tearDown(){
            driver.quit();
        }
        @Test
        public void myTest() throws InterruptedException {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/alerts");
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/alerts");

//            WebElement alertButton = driver.findElement(By.id("alertButton"));
//            WebElement promtButton = driver.findElement(By.id("promtButton"));
//            WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
//            WebElement confirmButton = driver.findElement(By.id("confirmButton"));
//            System.out.println(driver.getTitle());
//            promtButton.click();
//            Thread.sleep((3000));
//            Alert alert = driver.switchTo().alert();
//            alert.sendKeys("Selenium");
//            alert.accept();
////            alert.sendKeys("Selenium");
//            Thread.sleep(3000);
        }
}
