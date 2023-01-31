package Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

public class TestScreenshot {
    WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        driver = WebDriverManager.chromedriver().create();
    }

    @Test
    public void homePage() throws Exception {
        driver.get("https://anhtester.com");
        assertEquals(driver.getTitle(), "Anh Tester - Automation Testing");
        Thread.sleep(5000);
    }
    @AfterMethod  // result là biến đại diện cho method @Test
    public void takeScreenshot(ITestResult result) {
        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
        // Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        // passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CaptureHelpers.captureScreenshot(driver, "homePage");
//                // Tạo tham chiếu của TakesScreenshot
//                TakesScreenshot ts = (TakesScreenshot) driver;
//                // Gọi hàm capture screenshot - getScreenshotAs
//                File source = ts.getScreenshotAs(OutputType.FILE);
//                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
//                File theDir = new File("./Screenshots/");
//                if (!theDir.exists()) {
//                    theDir.mkdirs();
//                }
//                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
//                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
//                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
