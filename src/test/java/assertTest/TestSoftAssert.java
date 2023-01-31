package assertTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class TestSoftAssert{

    @Test(priority = 1)
    public void RunTest() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://anhtester.com");

        SoftAssert softassert = new SoftAssert();

        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();

        System.out.println("*** Checking For The First Title ***");

        softassert.assertEquals(originalTitle, expectedTitle);

        System.out.println("*** Checking For The Second Title ***");

        softassert.assertEquals(originalTitle, "Anh Tester - Automation Testing");

        softassert.assertAll();
    }
}