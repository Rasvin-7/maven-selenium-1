package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testcases.TestBases;

public class AllureListener extends TestBases implements ITestListener
{
//  Get the test method name
    public static String getMethodName(ITestResult iTestResult)
    {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
//  Return the screenshot
    @Attachment
    public byte[] saveScreenShot(WebDriver driver)
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
//  Return the log message
    @Attachment(value = "{0}",type = "text/plain")
    public static String saveTextLog(String message)
    {
        return message;
    }


//    @Override
//    public void onStart(ITestContext iTestContext) {
//        System.out.println("onStart Method " + iTestContext.getName());
//        iTestContext.setAttribute("WebDriver", TestBases.getDriver());
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//        System.out.println("onFinish Method " + iTestContext.getName());
//    }
//
//    @Override
//    public void onTestStart(ITestResult iTestResult) {
//        System.out.println("onTestStart Method " + getMethodName(iTestResult) + " start");
//    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess Method " + getMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure Method " + getMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance();
        WebDriver driver = TestBases.getDriver();
        // Allure ScreenShot and SaveTestLog
//        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case : " + getMethodName(iTestResult));
            saveScreenShot(driver);
//        }
        saveTextLog(getMethodName(iTestResult) + " failed and screenshot taken!");
    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped Method " + getMethodName(iTestResult) + " skipped");
    }




}
