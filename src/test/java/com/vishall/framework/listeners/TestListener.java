package com.vishall.framework.listeners;

import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.utils.LoggersUtil;
import com.vishall.framework.utils.ScreenShotUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import org.apache.logging.log4j.Logger;

public class TestListener implements ITestListener {

    private static final Logger log = LoggersUtil.getLogger(TestListener.class);


    @Override
    public void onStart(ITestContext context){
        log.info("Suite started: {}", context.getName());
    }

    @Override
    public void onTestStart(ITestResult result){
        String testName = result.getMethod().getMethodName();
        log.info("Test started: {}", testName);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        String testName = result.getMethod().getMethodName();
        log.info("Test passed: {}", testName);
        ScreenShotUtil.takeScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result){
        String testName = result.getMethod().getMethodName();

        log.error("Test failed: {}", testName);

        if (result.getThrowable() != null){
            log.error("Failure reason:", result.getThrowable());
        }

        ScreenShotUtil.takeScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result){
        String testName = result.getMethod().getMethodName();
        log.warn("Test failed: {}", testName);
    }

    @Override
    public void onFinish(ITestContext context){
        log.info("Suite Finished: {}", context.getName());
    }
}
