package com.vishall.framework.tests;

import com.vishall.framework.base.BasePage;
import com.vishall.framework.base.BaseTest;
import com.vishall.framework.pages.*;
import org.testng.annotations.Test;

public class WomensFashionNavTest extends BaseTest {

    WomensFashionNav womensFashion;
    WomensFashionPage clickBrandName;
    SwarovskiBrandPage choosingProduct;
    ProductPage productPage;
    Cart cart;


//    @Test
//    public void clickWomensFashionSection(){
//        womensFashion = new WomensFashionNav();
//        womensFashion.navToWomensFashion();
//    }

    @Test
    public void clickBrandNameinWomensFashion(){
        womensFashion = new WomensFashionNav();
        womensFashion.navToWomensFashion();

        clickBrandName = new WomensFashionPage();
        clickBrandName.selectBrand("Swarovski");

        choosingProduct = new SwarovskiBrandPage();
        choosingProduct.sortThePage();
        choosingProduct.clickOnProductName();

        productPage = new ProductPage();
        productPage.addToCart();
        productPage.goToCart();

        cart = new Cart();
        cart.SeeMoreLikeThisBtn();

    }
}
