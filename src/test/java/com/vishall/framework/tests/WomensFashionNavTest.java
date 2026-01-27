package com.vishall.framework.tests;

import com.vishall.framework.base.BasePage;
import com.vishall.framework.base.BaseTest;
import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.pages.*;
import com.vishall.framework.utils.LoggersUtil;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WomensFashionNavTest extends BaseTest {

    WomensFashionNav womensFashion;
    WomensFashionPage clickBrandName;
    SwarovskiBrandPage choosingProduct;
    ProductPage productPage; //= new ProductPage();
    Cart cart; //= new Cart();

    //Logger
    private static final Logger log= LoggersUtil.getLogger(WomensFashionNavTest.class);

    @Test
    public void addMaxCountOfProductToCart(){
        womensFashion = new WomensFashionNav();
        log.info("Navigating to women's fashion page");
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
        cart.productAddedOrNot();
    }

    @Test
    public void moreLikeThisButtonInCartPage() throws InterruptedException {

        womensFashion = new WomensFashionNav();
        log.info("Navigating to women's fashion page");
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
        log.info("Clicking on see more like this button and then waiting for see more like this menu to load fully inorder to take a better SS");
        cart.SeeMoreLikeThisBtn();


    }
}
