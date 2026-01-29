package com.vishall.framework.pages;

import com.vishall.framework.base.BasePage;
import org.openqa.selenium.By;

public class WomensFashionNav extends BasePage {
    private By allHamburgerMenu = By.id("nav-hamburger-menu");

    // private By womensClothing = By.xpath("//a[@class='hmenu-item']/div[text()=\"Women's Fashion\"]");
    private By womensClothing = By.xpath("//a[@data-menu-id='11']");


    //private By womensFashion = By.xpath("//a[@class='hmenu-item' and text()=\"Women's Fashion\"]");
    //|>done below

    public By womensFashionXpathBuilder(String option){
        //Ternary operator for handling words with single quotes and no quotes
        String optionParsed = option.contains("'") ? "\"" + option + "\"" : "'" + option +"'";

        return By.xpath("//a[@class='hmenu-item' and text()="+ optionParsed + "]");
    }

    public void navToWomensFashion(String option){
        click(allHamburgerMenu);

        //scrollTo(womensClothing);
        //click(womensClothing);
        clickUsingActions(womensClothing);
        //clickUsingEnter(womensClothing);

        // scrollTo(womensFashion);
        // click(womensFashion);
        //clickUsingActions(womensFashion);
        By womensFashion = womensFashionXpathBuilder(option);
        clickUsingEnter(womensFashion);
    }
}