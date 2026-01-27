package com.vishall.framework.driver;

import com.vishall.framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    //ThreadLocal object of type WebDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //creates new browser instance
    public static void initialize_driver(String browser){

        //if browser value from config.properties file is null, then throw the below exception.
        if (browser==null || browser.isBlank()){
            throw new RuntimeException("Browser value is missing");
        }

        //read headless or not from ConfigReader class
        boolean headless = Boolean.parseBoolean(ConfigReader.getProp("headless"));

        //if driver object's value is null, only then assign a browser to it.
        if(driver.get()==null){
            switch(browser.toLowerCase()){
                case "chrome":
                    driver.set(createChromeDriver(headless));
                    break;
                case "edge":
                    driver.set(createEdgeDriver(headless));
                    break;
                case "firefox":
                    driver.set(createFireFoxDriver(headless));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser name: "+browser);
            }
            driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }
    }

    //returns the WebDriver instance for the current thread
    //called in BaseTest before every @Test method execution starts
    public static WebDriver getDriver(){
        if(driver.get()==null){
            throw new IllegalStateException("Driver not initialized");
        }
        return driver.get();
    }

    //closes the browser
    //called in BaseTest after every @Test method execution is completed
    public static void quitDriver(){
        if (driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }


    private static WebDriver createChromeDriver(boolean headless){
        ChromeOptions options = new ChromeOptions();

        if(headless){
           options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
           options.addArguments("--window-size=1920,1080");
        }
        else {
            options.addArguments("--start-maximized");
        }
        return new ChromeDriver(options);
    }
    private static WebDriver createEdgeDriver(boolean headless){
        EdgeOptions options = new EdgeOptions();
        if(headless){
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }
        else {
            options.addArguments("start-maximized");
        }
        return new EdgeDriver(options);
    }
    private static WebDriver createFireFoxDriver(boolean headless){
        return new FirefoxDriver();
    }
}
