package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_FollowUs {
    @Given("user navigates to home page")
    public void navigateToHomepage()
    {
        String url = "https://demo.nopcommerce.com/";
        Hooks.driver.navigate().to(url);
    }

    @When("user open facebook link")
    public void userOpenFacebookLink() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("li[class=\"facebook\"] ")).click();
        Thread.sleep(3000);

    }
    @And("Open the second tab")
    public void openTheSecondTab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String>Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));

    }

    @When("user open twitter link")
    public void userOpenTwitterLink() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("li[class=\"twitter\"] ")).click();
        Thread.sleep(3000);

    }
    @And("Open the twitter tab")
    public void openTwitterTab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String>Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://twitter.com/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));

    }

    @When("user open rss link")
    public void userOpenRssLink() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("li[class=\"rss\"] ")).click();
        Thread.sleep(3000);

    }
    @And("Open the rss tab")
    public void openRssTab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String>Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/news/rss/1");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));

    }

    @When("user open youtube link")
    public void userOpenYoutubeLink() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("li[class=\"youtube\"] ")).click();
        Thread.sleep(3000);

    }
    @And("Open the youtube tab")
    public void openYoutubeTab() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String>Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce");
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));

    }
}
