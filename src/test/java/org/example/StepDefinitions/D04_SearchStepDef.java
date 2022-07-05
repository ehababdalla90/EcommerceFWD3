package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_Search;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.ArrayList;
import static org.openqa.selenium.Keys.ENTER;

public class D04_SearchStepDef {
    P04_Search search =new P04_Search();

    @When("user click on search field")
    public void clickSearchField(){
        search.searchfield().click();
    }

    @And("^user enter \"(.*)\" to search$")
    public void enterProductName(String searchName) throws InterruptedException {
        search.searchfield().sendKeys(searchName);
        search.searchBtn().sendKeys(ENTER);
        Thread.sleep(5000);
    }

    @Then("user find the product and relative products")
    public void findProduct(){
        int productsNum =Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        System.out.println(productsNum);
        Assert.assertTrue(productsNum>0);
        String url="https://demo.nopcommerce.com/search";
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(url));
        ArrayList<String> produtcResult;
        produtcResult= new ArrayList();
        for (int n=0;n<productsNum;n++){
            System.out.println(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(n).getText());
            produtcResult.add(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(n).getText());
       }
        System.out.println(produtcResult);
    }

    @Then("^user find \"(.*)\" product$")
    public void findOneProduct(String found) throws InterruptedException {
        int productsNum =Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        System.out.println(productsNum);
        Assert.assertEquals(productsNum,1);
        String url="https://demo.nopcommerce.com/search";
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(url));
        ArrayList<String> resultproducts=new ArrayList();
        for (int n=0;n<productsNum;n++){
            System.out.println(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(n).getText());
            resultproducts.add(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(n).getText());
        }
        System.out.println(resultproducts);
        search.founded().click();
        Thread.sleep(3000);
        String actual=Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"] span[class=\"value\"]")).getText();
        Assert.assertTrue(actual.contains(found),"Right product founded");
    }
}
