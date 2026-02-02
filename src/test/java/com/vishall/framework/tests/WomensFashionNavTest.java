package com.vishall.framework.tests;

import com.aventstack.extentreports.ExtentTest;
import com.vishall.framework.base.BaseTest;
import com.vishall.framework.pages.*;
import com.vishall.framework.reports.ExtentTestManager;
import com.vishall.framework.utils.DataProviderJson;
import com.vishall.framework.utils.LoggersUtil;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class WomensFashionNavTest extends BaseTest {

    WomensFashionNav womensFashion;
    WomensFashionPage clickBrandName;
    SelectedBrandsPage choosingProduct;
    ProductPage productPage; //= new ProductPage();
    Cart cart; //= new Cart();

    //Logger calling & creation for this class
    private static final Logger log= LoggersUtil.getLogger(WomensFashionNavTest.class);


    @DataProvider(name = "testDataForWomensFashionNavTest")
    public Object[][] dp() throws Exception {
        // Important: include the leading slash if you concatenated with user.dir
        return DataProviderJson.jsonforHashMapCOnversionTestNG("/src/test/resources/WomensFashionNavTestData.json");
    }


    @Test(groups = {"smoke","regression"}, dataProvider="testDataForWomensFashionNavTest")
    public void addMaxCountOfProductToCart(HashMap<String, String> data){
        womensFashion = new WomensFashionNav();

        log.info("Navigating to women's fashion page");
        ExtentTestManager.getTest().info("Navigating to women's fashion page");

        womensFashion.navToWomensFashion(data.get("FashionToSelect"));

        clickBrandName = new WomensFashionPage();
        clickBrandName.selectBrand(data.get("BrandName"));

        choosingProduct = new SelectedBrandsPage();
        choosingProduct.sortThePage();
        choosingProduct.clickOnProductName(data.get("ProductName"));

        productPage = new ProductPage();
        productPage.addToCart();
        productPage.goToCart();

        cart = new Cart();
        log.info("Doing assert to confirm if selected product is added");
        ExtentTestManager.getTest().info("Doing assert to confirm if selected product is added");

        String expectedName = data.get("ProductName");
        String productNameRetrieved = cart.productAddedOrNot(expectedName);

        log.info("Actual result:" + productNameRetrieved);
        ExtentTestManager.getTest().info("Actual result:" + productNameRetrieved);
        log.info("Expected result" + expectedName);
        ExtentTestManager.getTest().info("Expected result:" + expectedName);

        Assert.assertTrue(productNameRetrieved.contains(expectedName), "Expected product is not present.\nExpected to contain: " + expectedName + "\nActual: " + productNameRetrieved);

    }

    @Test(groups = {"regression"}, dataProvider = "testDataForWomensFashionNavTest")
    public void moreLikeThisButtonInCartPage(HashMap<String,String> data) throws InterruptedException {

        womensFashion = new WomensFashionNav();
        log.info("Navigating to women's fashion page");
        ExtentTestManager.getTest().info("Navigating to women's fashion page");

        womensFashion.navToWomensFashion(data.get("FashionToSelect"));

        clickBrandName = new WomensFashionPage();
        clickBrandName.selectBrand(data.get("BrandName"));

        choosingProduct = new SelectedBrandsPage();
        choosingProduct.sortThePage();
        choosingProduct.clickOnProductName(data.get("ProductName"));

        productPage = new ProductPage();
        productPage.addToCart();
        productPage.goToCart();

        cart = new Cart();

        log.info("Clicking on see more like this button and then waiting for see more like this menu to load fully inorder to take a better SS");
        ExtentTestManager.getTest().info("Clicking on see more like this button and then waiting for see more like this menu to load fully inorder to take a better SS");

        cart.SeeMoreLikeThisBtn();
    }
}