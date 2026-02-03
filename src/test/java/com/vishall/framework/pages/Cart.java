package com.vishall.framework.pages;

import com.vishall.framework.base.BasePage;
import com.vishall.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Cart extends BasePage {
    //By seeMoreLikeThis = By.name("submit.compare.6faab078-4f70-48de-9882-874d8f6b38fb");
    //The above one didn't work since the name also contains randomly generated id after submit.compare.

    //link text can only be used for <a> anchor tags
    //By addedProductName = By.linkText("Swarovski Iconic Swan Bangle, Swan, Black, Rose Gold-Tone Plated");
    By seeMoreLikeThis = By.xpath("//input[contains(@name,'submit.compare')]");
    By seeMoreLikeThisMenuLoaded = By.xpath("//h1[contains(normalize-space(), 'More items like this')]");

    public String productAddedOrNot(String productName){
        //By selectedProduct = By.xpath("(//span[contains(text(),'"+productName+"')])[1]");
        By selectedProduct = By.xpath("//h4[contains(@class,'a-text-normal')]"
                        + "//span[contains(@class,'a-truncate-cut') and contains(normalize-space(.), '" + productName + "')]"
        );

        return getText(selectedProduct);
    }
    public void SeeMoreLikeThisBtn() throws InterruptedException {
        click(seeMoreLikeThis);
        WaitUtils.waitForVisibility(seeMoreLikeThisMenuLoaded);
    }
}
