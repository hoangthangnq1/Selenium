package Listener;

import Screenshot.CaptureHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

        @Override
        public void onFinish(ITestContext result) {
        }
        @Override
        public void onStart(ITestContext result) {

        }
        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        }
        @Override
        public void onTestFailure(ITestResult result) {
                System.out.println("Đây là test case bị fail: " + result.getName());
                try {
                        CaptureHelpers.captureScreenshot(BaseTest.driver, result.getName());
                } catch (Exception e) {
                        System.out.println("Exception while taking screenshot " + e.getMessage());
                }

        }
        @Override
        public void onTestSkipped(ITestResult result) {
                System.out.println("Đây là test case bị bỏ qua: " + result.getName());

        }
        @Override
        public void onTestStart(ITestResult result) {

        }
        @Override
        public void onTestSuccess(ITestResult result) {
                System.out.println("Đây là test case chạy thành công: " + result.getName());
        }
}
