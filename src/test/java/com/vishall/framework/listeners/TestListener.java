package com.vishall.framework.listeners;

import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.utils.ScreenShotUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {


    @Override
    public void onStart(ITestContext context){
        System.out.println("Suite started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test passed: " + result.getMethod().getMethodName());
        ScreenShotUtil.takeScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test failed: " + result.getMethod().getMethodName());
        ScreenShotUtil.takeScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test failed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("Suite Finished: " + context.getName());
    }
}
