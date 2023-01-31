package action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest {
    public static void main(String[] args) throws InterruptedException {
        // specify the driver location
        WebDriver driver = WebDriverManager.chromedriver().create();

        // instantiate the driver
        // maximise the window
        driver.manage().window().maximize();

        // specify the URL of the webpage
        driver.get("https://www.google.com/");

        // specify the locator of the search box
        WebElement element = driver.findElement(
                By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));
        // create an object for the Actions class and pass the driver argument
        Actions action = new Actions(driver);

        // pass the product name that has to be searched in the website
        action.sendKeys(element, "Anh Tester").build().perform();
        Thread.sleep(2000);
        driver.quit();
    }
}



