package com.vishall.framework.tests;

import com.vishall.framework.base.BaseTest;
import com.vishall.framework.pages.WomensFashionNav;
import org.testng.annotations.Test;

public class WomensFashionNavTest extends BaseTest {

    @Test
    public void clickWomensFashionSection(){
        WomensFashionNav womensFashion = new WomensFashionNav();
        womensFashion.navToWomensFashion();
    }
}
