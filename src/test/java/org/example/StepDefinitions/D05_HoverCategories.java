package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class D05_HoverCategories {
    @Given("user could navigates to the website homepage")
    public void navigateHomePage() {
        String url = "https://demo.nopcommerce.com/";
        Hooks.driver.navigate().to(url);
    }

    @When("user hover the main category")
    public void userHoverTheMainCategory() {
        Hooks.driver.findElement(By.className("menu-toggle")).click();

    }

    @When("user hovers category and selects a sub-category")
    public void userHoversCategoryAndSelectsASubCategory() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        //hover on computers
        WebElement computersCategory = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));
        //WebElement computersCategory = Hooks.driver.findElement(By.xpath("//a[@href=\"/computers\"]"));
        action.moveToElement(computersCategory).build().perform();
        
        //hover on Computers -> desktops sub-category
        WebElement desktopsSubcategory = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]"));
        Thread.sleep(3000);

        action.moveToElement(desktopsSubcategory).click().build().perform();
        Thread.sleep(3000);

        String desktopsSubCategoryName = Hooks.driver.findElement(By.className("page-title")).getText().toLowerCase().trim();
        System.out.println(desktopsSubCategoryName);



        // use hard assertion
        String subCategoryWebPageTitle = Hooks.driver.getCurrentUrl();
        System.out.println(subCategoryWebPageTitle);
        Assert.assertTrue(subCategoryWebPageTitle.contains(desktopsSubCategoryName));



    }
}