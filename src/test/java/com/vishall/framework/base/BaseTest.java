package com.vishall.framework.base;

import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.listeners.TestListener;
import com.vishall.framework.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class BaseTest {
    @BeforeMethod
    //create browser for current test thread
    public void setup(){
        //initializes the requested browser
        //sends the browser name to DriverFactory class from config.properties file
        DriverFactory.initialize_driver(ConfigReader.getProp("browser"));
        //code for if browser should execute headless or not is created in DriverFactory class

        //opens url
        DriverFactory.getDriver().get(ConfigReader.getUrl());

    }

    @AfterMethod
    public void tearDown(){
       // DriverFactory.quitDriver();
    }
}
