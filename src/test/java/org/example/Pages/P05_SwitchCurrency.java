package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class P05_SwitchCurrency {

    public WebElement chooseEuro(){

        WebElement euro= Hooks.driver.findElement(By.id("customerCurrency"));
        Select selectCurrency=new Select(euro);
        selectCurrency.selectByVisibleText("Euro");
        return euro;
    }

    public WebElement chooseUSD(){

        WebElement usd=Hooks.driver.findElement(By.id("customerCurrency"));
        Select selectCurrency=new Select(usd);
        selectCurrency.selectByVisibleText("US Dollar");
        return usd;
    }
    public List<WebElement> currencyEuro(){
        int count =Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).size();
        for(int x=0;x<count;x++) {
            String actual = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).get(x).getText();
            String expected = "€";
            Assert.assertTrue(actual.contains(expected), "Error in currency");
        }
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public List<WebElement> currencyDollar(){
        int count =Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).size();
        for(int x=0;x<count;x++) {
            String actual = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).get(x).getText();
            String expected = "$";
            Assert.assertTrue(actual.contains(expected), "Error in currency");
        }
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }
}
