package com.vishall.framework.utils;

import com.vishall.framework.driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShotUtil {
    public static void takeScreenshot(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File("screenshots/" + result.getMethod().getMethodName() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS")) + ".png");
                FileUtils.copyFile(src, dest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
