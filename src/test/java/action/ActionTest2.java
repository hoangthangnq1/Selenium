package action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://anhtester.com/");

        WebElement element = driver.findElement(
                By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

//        action.doubleClick(element).build().perform();
//
//        action.contextClick(element).build().perform();

        WebElement element2 = driver.findElement(
                By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));
        action.moveToElement(element2).build().perform();
        Thread.sleep(2000);
        driver.quit();
    }
}



