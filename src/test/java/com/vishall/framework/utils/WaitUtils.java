package com.vishall.framework.utils;

import com.vishall.framework.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class WaitUtils {

    public static final Duration TIMEOUT = Duration.ofSeconds(15);

    //Generic wait -- can be used for all wait types
    public static <T> T waitFor(ExpectedCondition<T> condition){
        return new WebDriverWait(DriverFactory.getDriver(), TIMEOUT).until(condition);
    }

    //Semantic waits --for daily use, with more common methods for ease of understanding and access for all levels of people
    //we are using the generics method from above here for regularly called waits inorder to reduce coding effort
    //for rarer waits, we can call the wait using the waitFor method itself directly in POM class
    public static WebElement waitForVisibility(By locator){
        return waitFor(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static List<WebElement> waitForVisibilityOfAllElements(By locator){
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement waitForClickability(By locator){
        return waitFor(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForElementInvisibility(By locator){
        return waitFor(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static WebElement waitForPresence(By locator){
        return waitFor(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
