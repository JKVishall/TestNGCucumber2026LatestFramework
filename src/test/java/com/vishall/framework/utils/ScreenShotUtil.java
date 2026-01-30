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
    public static String takeScreenshot(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        String screenshotPath = null;

        if (driver != null) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                screenshotPath = "screenshots/" + result.getMethod().getMethodName() +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS")) + ".png";
                File dest = new File(screenshotPath);

                FileUtils.copyFile(src, dest);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return screenshotPath;
    }
}
