package action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest3 {
    public static void main(String[] args) throws InterruptedException {
        // specify the driver location
        WebDriver driver = WebDriverManager.chromedriver().create();

        // instantiate the driver
        // maximise the window
        driver.manage().window().maximize();

        // specify the URL of the webpage
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        // Element which needs to drag.
        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        // Element on which need to drop.
        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

        Actions action = new Actions(driver);
        Thread.sleep(1000);
        // Dragged and dropped.
        action.dragAndDrop(From, To).build().perform();

        Thread.sleep(1000);
        // Drag and Drop by Pixel.
        WebElement from_5000 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement to_5000 = driver.findElement(By.xpath("//ol[@id='amt7']"));
        action.clickAndHold(from_5000).moveToElement(to_5000).release().build().perform();

        Thread.sleep(2000);
        driver.quit();
    }
}



