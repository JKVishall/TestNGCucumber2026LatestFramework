package com.vishall.framework.pages;

import com.vishall.framework.base.BasePage;
import com.vishall.framework.driver.DriverFactory;
import com.vishall.framework.utils.JSEUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomensFashionNav extends BasePage {
    private By allHamburgerMenu = By.id("nav-hamburger-menu");

   // private By womensClothing = By.xpath("//a[@class='hmenu-item']/div[text()=\"Women's Fashion\"]");
    private By womensClothing = By.xpath("//a[@data-menu-id='11']");

    private By womensFashion = By.xpath("//a[@class='hmenu-item' and text()=\"Women's Fashion\"]");

    public void navToWomensFashion(){
        click(allHamburgerMenu);

        //scrollTo(womensClothing);
        //click(womensClothing);
        clickUsingActions(womensClothing);
        //clickUsingEnter(womensClothing);

       // scrollTo(womensFashion);
       // click(womensFashion);
        //clickUsingActions(womensFashion);
         clickUsingEnter(womensFashion);
    }
}
