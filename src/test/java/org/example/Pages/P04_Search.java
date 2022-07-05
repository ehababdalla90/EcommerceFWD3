package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P04_Search {

    public WebElement searchfield(){
        By search=By.cssSelector("input[id=\"small-searchterms\"]");
        WebElement searchfield= Hooks.driver.findElement(search);
        return searchfield;
    }

    public WebElement searchBtn() {

        WebElement searchBtn=Hooks.driver.findElement(By.cssSelector("input[id=\"small-searchterms\"]"));
        return searchBtn;
    }

    public WebElement founded(){
        By found=By.cssSelector("h2[class=\"product-title\"] a");
        WebElement foundBtn=Hooks.driver.findElement(found);
        return foundBtn;
    }

}