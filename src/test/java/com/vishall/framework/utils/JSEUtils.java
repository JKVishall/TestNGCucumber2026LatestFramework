package com.vishall.framework.utils;

import com.vishall.framework.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSEUtils {

    private static JavascriptExecutor getJSExecutor(){
        return (JavascriptExecutor) DriverFactory.getDriver();
    }

    public static void scrollIntoView(WebElement element){
        getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToBottom(WebElement element){
        getJSExecutor().executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }
}
