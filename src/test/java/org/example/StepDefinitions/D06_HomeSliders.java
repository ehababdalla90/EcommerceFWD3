package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D06_HomeSliders {
    @Given("user could navigates to the  homepage")
    public void navigatesHomepage()
    {
        String url = "https://demo.nopcommerce.com/";
        Hooks.driver.navigate().to(url);
    }

    @When("user could navigate Nokia products through homeSliders")
    public void navigateHomeSliders() throws InterruptedException {
        Hooks.driver.findElement(By.className("nivo-imageLink")).click();
        Thread.sleep(4000);
        String pageTitle = Hooks.driver.findElement(By.className("nivo-imageLink")).getText();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle,"https://demo.nopcommerce.com/search?q=nokia");
    }
}
