package com.vishall.framework.pages;

import com.vishall.framework.base.BasePage;
import com.vishall.framework.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ProductPage extends BasePage {
    //By quantityElement = By.name("quantity");
    By quantityElement = By.xpath("//span/select[@id='quantity']");

    By addToCartBtn = By.id("add-to-cart-button");

    By goToCartBtn = By.linkText("          Go to Cart");

    public void addToCart(){
        switchToSecondWindow();
        WebElement a = DriverFactory.getDriver().findElement(By.id("productTitle"));
        System.out.println(a.getText());
        selectByIndex(quantityElement);
        click(addToCartBtn);
    }

    public void goToCart(){
        //method from BasePage class
        goToCartBtnUniversal();
    }
}
