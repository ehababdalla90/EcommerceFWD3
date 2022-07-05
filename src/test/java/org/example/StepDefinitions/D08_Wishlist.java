package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class D08_Wishlist {
    @When("Click on wishlist button")
    public void clickOnWishlistButton() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/18/2/1\"),!1']")).click();
        //Thread.sleep(5000);
    }

    @And("AssertSuccessMessage")
    public void assertSuccessMessage() {
        String successMessage = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getText();
        System.out.println(successMessage);
        Assert.assertEquals(successMessage,"The product has been added to your wishlist");

    }

    @And("Get RGBA value")
    public void getRGBAValue() {
        String rgbaValue = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
        System.out.println(rgbaValue);
        String hex = Color.fromString(rgbaValue).asHex();
        System.out.println(hex);
        //assert background color is green
        Assert.assertEquals(hex,"#4bb07a");

    }
    //Scenario #2 check the wishlist QTY is greater than 0
    @And("Click on wishlist button in main bar")
    public void clickOnWishlistButtonInMainBar() {
        WebElement successBar = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
        //explicit wait
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(successBar));
        Hooks.driver.findElement(By.xpath("//span[@class='wishlist-label']")).click();


    }

    @Then("Check the QTY in wishlist is greater than 0")
    public void checkQTY() {
        String qty = Hooks.driver.findElement(By.className("qty-input")).getAttribute("value");
        System.out.println("attribute value "+qty);
        int qtyValue = Integer.parseInt(qty);
        Assert.assertNotEquals(qtyValue,0);

    }
}
