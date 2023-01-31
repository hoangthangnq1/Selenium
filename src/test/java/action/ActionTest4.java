package action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest4 {
    public static void main(String[] args) throws InterruptedException {
        // specify the driver location
        WebDriver driver = WebDriverManager.chromedriver().create();

        // instantiate the driver
        // maximise the window
        driver.manage().window().maximize();

        // specify the URL of the webpage
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

        WebElement element = driver.findElement(
                By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh tester").build().perform();

        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void ScrollPage() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();

        // specify the URL of the webpage
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://anhtester.com/");

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll down
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        // Scroll up
        action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();

        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void CopyAndPaste() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();

        // instantiate the driver
        // maximise the window
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://anhtester.com/blogs");

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm khóa học . . .']"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm bài viết . . .']"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("testing");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown( Keys.CONTROL ).sendKeys( "c" ).keyUp( Keys.CONTROL ).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown( Keys.CONTROL ).sendKeys( "v" ).keyUp( Keys.CONTROL ).build().perform();

        Thread.sleep(2000);
        driver.quit();
    }
}



