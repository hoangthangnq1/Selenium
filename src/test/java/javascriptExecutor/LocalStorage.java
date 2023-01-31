package javascriptExecutor;

import data.provider.DPClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class LocalStorage {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://demoqa.com");
    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Tạo alert trên trang web
        js.executeScript("window.localStorage.setItem(arguments[0],arguments[1])","age","30");
        System.out.println((String) js.executeScript("return window.localStorage.getItem(arguments[0])", "age"));
        Thread.sleep(2000);
    }
}
