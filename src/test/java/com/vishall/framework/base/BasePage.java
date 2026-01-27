package com.vishall.framework.base;

import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.utils.JSEUtils;
import com.vishall.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

   //find element and return it as WebElement
    protected WebElement find(By locator){
        return WaitUtils.waitForVisibility(locator);
    }

    //find elements ie.,List<WebElement>
    protected List<WebElement> findElements(By locator){
        return WaitUtils.waitForVisibilityOfAllElements(locator);
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

    //custom built method
    //
    protected void clickUsingProductName(String productName){
        By productNameElement = By.xpath("//a[.//h2[@aria-label='"+productName+"']]");
        click(productNameElement);
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

    //select dropdown
    Select select;
    protected void selectByVisibleText(By locator, String keyText){
        select = new Select(find(locator));
        select.selectByVisibleText(keyText);
    }

    protected void selectByIndex(By locator){
        select = new Select(find(locator));
        List<WebElement> numOfProductsAvailable = select.getOptions();
        int productCount = numOfProductsAvailable.size();

        //selecting maximum number of products
        //using -1 since indexing will be from 0, unlike .size() which counts from 1
        select.selectByIndex(productCount-1);

       DriverFactory.getDriver().findElement(By.tagName("body")).click();
    }

    //get window handles and switch to specific window
    protected void switchToSpecificWindow(String expectedWindowTitle){
        String currentWindow = DriverFactory.getDriver().getWindowHandle();
        String parentWindowTitle = DriverFactory.getDriver().getTitle();

        Set<String> allWindows = DriverFactory.getDriver().getWindowHandles();

        List<String> windowsNames = new ArrayList<>();
        for (String k: allWindows){
            windowsNames.add(k);
        }
        for (String a: allWindows) {
            //if(!a.equals(currentWindow))
            String currentWindowTitle = DriverFactory.getDriver().getTitle();
            if (currentWindowTitle.equals(expectedWindowTitle)){
                DriverFactory.getDriver().switchTo().window(currentWindowTitle);
            }
        }
    }

    //get window handles and switch to specific window
    protected void switchToSecondWindow() {
        Set<String> allWindows = DriverFactory.getDriver().getWindowHandles();

        List<String> windowsNames = new ArrayList<>();
        for (String k: allWindows){
            windowsNames.add(k);
        }
        int windowsCount = windowsNames.size();
        DriverFactory.getDriver().switchTo().window(windowsNames.get(windowsCount-1));
    }

    protected void goToCartBtnUniversal(){
        click(By.id("nav-cart"));
    }
}
