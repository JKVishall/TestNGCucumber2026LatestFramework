package com.vishall.framework.pages;

import com.vishall.framework.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Cart extends BasePage {
    //By seeMoreLikeThis = By.name("submit.compare.6faab078-4f70-48de-9882-874d8f6b38fb");
    //The above one didn't work since the name also contains randomly generated id after submit.compare.

    By addedProductName = By.linkText("Swarovski Iconic Swan Bangle, Swan, Black, Rose Gold-Tone Plated");
    By seeMoreLikeThis = By.xpath("//input[contains(@name,'submit.compare')]");


    public void productAddedOrNot(){
        Assert.assertEquals(find(addedProductName).getText(), "Swarovski Iconic Swan Bangle, Swan, Black, Rose Gold-Tone Plated");
    }
    public void SeeMoreLikeThisBtn(){
        click(seeMoreLikeThis);
    }
}
