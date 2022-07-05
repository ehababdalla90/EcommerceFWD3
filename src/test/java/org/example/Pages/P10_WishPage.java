package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P10_WishPage {
    public WebElement htc(){

        WebElement htcM8= Hooks.driver.findElement(By.cssSelector("a[href=\"/htc-one-m8-android-l-50-lollipop\"]"));
        return htcM8;
    }
    public WebElement addToWishList(){

        WebElement wishList=Hooks.driver.findElement(By.id("add-to-wishlist-button-18"));
        return wishList;
    }
    public WebElement successMessage(){
        By noty=By.cssSelector("div[class=\"bar-notification success\"]");
        WebElement notify=Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
        return notify;
    }


}
