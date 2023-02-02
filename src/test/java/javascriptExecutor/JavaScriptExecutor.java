package javascriptExecutor;

import data.provider.DPClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {
    WebDriver driver;

//    @BeforeClass
//    public void beforeMethod() {
//
//    }
//
//    @AfterClass
//    public void afterMethod() {
//
//    }

    @Test
    public void executorTest() throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://demoqa.com");
        System.out.println("Started Driver");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Tạo alert trên trang web
        //scrollIntoView and click
        WebElement webElement = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", webElement);
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Closed Driver");
    }
}
