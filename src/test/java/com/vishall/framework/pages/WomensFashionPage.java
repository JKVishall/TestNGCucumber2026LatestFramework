package com.vishall.framework.pages;

import com.vishall.framework.base.BasePage;
import org.openqa.selenium.By;

public class WomensFashionPage extends BasePage{

    private By brandElement(String brandName) {
        return By.xpath("//a[.//img[contains(@src,'" + brandName + "')]]");
    }

    public void selectBrand(String brandName){
        By brandElementName = brandElement(brandName);
        click(brandElementName);
    }
}
