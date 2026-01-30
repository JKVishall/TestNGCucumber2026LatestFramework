package com.vishall.framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.reports.ExtentManager;
import com.vishall.framework.reports.ExtentTestManager;
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

    //Logger instance
    private static final Logger log = LoggersUtil.getLogger(TestListener.class);
    //ExtentReports instance
    private static ExtentReports extent = ExtentManager.getInstance();


    @Override
    public void onStart(ITestContext context){
        log.info("Suite started: {}", context.getName());
    }

    @Override
    public void onTestStart(ITestResult result){
        String testName = result.getMethod().getMethodName();

        ExtentTest extentTest = extent.createTest(testName);
        ExtentTestManager.setTest(extentTest);

        log.info("Test started: {}", testName);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        String testName = result.getMethod().getMethodName();

        ScreenShotUtil.takeScreenshot(result);

        ExtentTestManager.getTest().pass("Test passed");

        log.info("Test passed: {}", testName);
    }

    @Override
    public void onTestFailure(ITestResult result){
        String testName = result.getMethod().getMethodName();

        ScreenShotUtil.takeScreenshot(result);

        ExtentTestManager.getTest().fail(result.getThrowable());

        log.error("Test failed: {}", testName);

        if (result.getThrowable() != null){
            log.error("Failure reason:", result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        String testName = result.getMethod().getMethodName();

        ExtentTestManager.getTest().skip("Test skipped");

        log.warn("Test failed: {}", testName);
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
        log.info("Suite Finished: {}", context.getName());
    }
}
