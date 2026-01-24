package com.vishall.framework.utils;

import com.vishall.framework.driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;

public class ScreenShotUtil {
    public static void takeScreenshot(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File("screenshots/" + result.getMethod().getMethodName() + ".png");
                FileUtils.copyFile(src, dest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
