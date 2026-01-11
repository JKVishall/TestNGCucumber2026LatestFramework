package com.vishall.framework.utils;

import com.vishall.framework.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSEUtils {

    //accessing jsExecutor
    private static JavascriptExecutor getJSExecutor(){
        return (JavascriptExecutor) DriverFactory.getDriver();
    }

    //JS click(fallback for when normal click operation fails
    public static void click(WebElement element){
        getJSExecutor().executeScript("argument[0].click();", element);
    }


    //scroll element into view
    public static void scrollIntoView(WebElement element){
        getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //scroll to bottom
    public static void scrollToBottom(WebElement element){
        getJSExecutor().executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }
}
