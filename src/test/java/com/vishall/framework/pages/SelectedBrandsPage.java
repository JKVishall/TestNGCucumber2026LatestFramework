package com.vishall.framework.pages;

import com.vishall.framework.base.BasePage;
import org.openqa.selenium.By;

public class SelectedBrandsPage extends BasePage {
    By sortByMenu = By.xpath("//select[@name='s']");

    private By findElementUsingProductName(String productName){
         return By.xpath("//a[.//h2[@aria-label='"+productName+"']]");
    }

    public void sortThePage(){
        selectByVisibleText(sortByMenu, "Price: Low to High");
    }

    //This method will call findElementUsingProductName method and will send the value received from DataProvider to it
    //This value sent will be used as a custom value and xpath will be built on it
    public void clickOnProductName(){
        By productNameElement = findElementUsingProductName("Iconic Swan Bangle, Swan, Black, Rose Gold-Tone Plated");
        click(productNameElement);
    }
}
