package assertTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssert {
    @Test(priority = 1)
    public void RunTest() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://anhtester.com");
        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();
        System.out.println("*** Checking For The Title ***");
        Assert.assertEquals(originalTitle, expectedTitle);
    }
}
