package com.vishall.framework.tests;

import com.vishall.framework.base.BasePage;
import com.vishall.framework.base.BaseTest;
import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WomensFashionNavTest extends BaseTest {

    WomensFashionNav womensFashion;
    WomensFashionPage clickBrandName;
    SwarovskiBrandPage choosingProduct;
    ProductPage productPage = new ProductPage();
    Cart cart = new Cart();


//    @Test
//    public void clickWomensFashionSection(){
//        womensFashion = new WomensFashionNav();
//        womensFashion.navToWomensFashion();
//    }

    @Test
    public void addMaxCountOfProductToCart(){
        womensFashion = new WomensFashionNav();
        womensFashion.navToWomensFashion();

        clickBrandName = new WomensFashionPage();
        clickBrandName.selectBrand("Swarovski");

        choosingProduct = new SwarovskiBrandPage();
        choosingProduct.sortThePage();
        choosingProduct.clickOnProductName();

        productPage.addToCart();
        productPage.goToCart();

        cart.productAddedOrNot();
    }

    @Test(dependsOnMethods = "addMaxCountOfProductToCart")
    public void moreLikeThisButtonInCartPage(){
        productPage.goToCart();
        cart.SeeMoreLikeThisBtn();
    }
}
