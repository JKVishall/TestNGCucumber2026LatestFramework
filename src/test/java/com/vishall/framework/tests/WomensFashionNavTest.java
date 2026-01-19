package com.vishall.framework.tests;

import com.vishall.framework.base.BaseTest;
import com.vishall.framework.pages.WomensFashionNav;
import com.vishall.framework.pages.WomensFashionPage;
import org.testng.annotations.Test;

public class WomensFashionNavTest extends BaseTest {

    WomensFashionNav womensFashion;
    WomensFashionPage clickBrandName;
    @Test
    public void clickWomensFashionSection(){
        womensFashion = new WomensFashionNav();
        womensFashion.navToWomensFashion();
    }

    @Test
    public void clickBrandNameinWomensFashion(){
        womensFashion = new WomensFashionNav();
        womensFashion.navToWomensFashion();
        clickBrandName = new WomensFashionPage();
        clickBrandName.selectBrand("Swarovski");
    }
}
