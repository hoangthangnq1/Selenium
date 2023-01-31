package Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class PropertiesTest {
    private WebDriver driver;

    @BeforeClass
    public void createDriver() {
        // Gọi hàm để khởi tạo file properties
        PropertiesFile.setPropertiesFile();
        // Đọc data từ file properties với key là "browser"
        PropertiesFile.setPropValue("env", "ci");
        if (PropertiesFile.getPropValue("browser").equals("chrome")){
            driver = WebDriverManager.chromedriver().create();
        }
        System.out.println(PropertiesFile.getPropValue("env"));
    }

    @Test
    public void signin() throws InterruptedException {
        driver.get(PropertiesFile.getPropValue("url"));
        // Đọc data từ file properties
        WebElement inputUseranme = driver.findElement(By.id("mat-input-3"));
        WebElement inputPassword = driver.findElement(By.id("mat-input-4"));
        WebElement btnSubmit = driver.findElement(By.id("kt_login_signin_submit"));
        inputUseranme.sendKeys(PropertiesFile.getPropValue("username"));
        inputPassword.sendKeys(PropertiesFile.getPropValue("password"));
        btnSubmit.click();
        System.out.println(PropertiesFile.getPropValue("username"));
        System.out.println(PropertiesFile.getPropValue("password"));
        Thread.sleep(3000);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
