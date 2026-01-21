package com.vishall.framework.base;

import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    //create browser for current test thread
    public void setup(){
        //initializes the requested browser
        //sends the browser name to DriverFactory class from config.properties file
        DriverFactory.initialize_driver(ConfigReader.getProp("browser"));

        //opens url
        DriverFactory.getDriver().get(ConfigReader.getProp("url"));
    }

    @AfterMethod
    public void tearDown(){
        //DriverFactory.quitDriver();
    }
}
