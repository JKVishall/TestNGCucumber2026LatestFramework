package com.vishall.framework.base;

import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.utils.JSEUtils;
import com.vishall.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BasePage {

   //find element and return it as WebElement
    protected WebElement find(By locator){
        return WaitUtils.waitForVisibility(locator);
    }

    //find() is a method in BasePage which finds a WebElement and stores it.
    //scrollIntoView takes a WebElement as input, so we are finding an element using find() method and sending it inside scrollIntoView() method
    protected void scrollTo(By locator){
         JSEUtils.scrollIntoView(find(locator));
    }

    //click on an element
    protected void click(By locator){
        try {
            //waits till the element is clickable and then clicks
            WaitUtils.waitForClickability(locator).click();
        } catch (Exception e){
            JSEUtils.click(find(locator));
        }
    }

    //click on an element using Actions class's moveToElement(find(locator)).click() action
    protected void clickUsingActions(By locator){
        new Actions(DriverFactory.getDriver()).moveToElement(find(locator))
                .pause(Duration.ofMillis(300))
                .click()
                .perform();
    }

    //click on an element using sendKeys(Keys.ENTER);
    protected void clickUsingEnter(By locator){
        find(locator).sendKeys(Keys.ENTER);
    }

    //custom built method
    //click on an element using
    protected void clickUsingBrandName(String brandName){
        By brandNameElement = By.xpath("//a[.//img[contains(@src,'"+brandName+"')]]");
        click(brandNameElement);
    }

    //sendkeys
    protected void type(By locator, String text){
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }






    //return the text of an element
    protected String getText(By locator){
        return find(locator).getText();
    }

    //check if element is displayed or not
    protected boolean isDisplayed(By locator){
        try{
            return find(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    //hover
    protected void hover(By locator){
        new Actions(DriverFactory.getDriver()).moveToElement(find(locator))
                .pause(Duration.ofMillis(300))
                .perform();
    }
}
