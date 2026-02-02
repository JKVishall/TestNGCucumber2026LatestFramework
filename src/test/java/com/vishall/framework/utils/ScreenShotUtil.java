package com.vishall.framework.utils;

import com.vishall.framework.driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShotUtil {
    public static String takeScreenshot(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        String screenshotPath = null;

        if (driver != null) {
            try {
                //Takes screenshot and stores in temp File
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);



                // 2) Ensure output directory exists
                Path folder = Paths.get("test-output", "screenshots");
                Files.createDirectories(folder);


                //Custom date and time formats
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH-mm-ss");

                //Custom name format
                String testCaseName = "Test case_" + result.getMethod().getMethodName();

                //Setting the custom data time format to data and time variables
                String date = now.format(dateFormatter);
                String time = now.format(timeFormatter);


                //setting them all up together
                screenshotPath = testCaseName + "_Date_" + date + "_Time_" + time + ".png";

               /* screenshotPath = "test-output/screenshots/"+result.getMethod().getMethodName() +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS")) + ".png";*/
                File dest = new File("test-output/screenshots/"+screenshotPath);

                FileUtils.copyFile(src, dest);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "screenshots/"+screenshotPath;
    }
}
