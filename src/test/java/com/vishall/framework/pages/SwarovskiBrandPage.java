package com.vishall.framework.pages;

import com.vishall.framework.base.BasePage;
import org.openqa.selenium.By;

public class SwarovskiBrandPage extends BasePage {
    By sortByMenu = By.xpath("//select[@name='s']");

    public void sortThePage(){
        selectByVisibleText(sortByMenu, "Price: Low to High");
    }

    public void clickOnProductName(){
        clickUsingProductName("Iconic Swan Bangle, Swan, Black, Rose Gold-Tone Plated");
    }
}
