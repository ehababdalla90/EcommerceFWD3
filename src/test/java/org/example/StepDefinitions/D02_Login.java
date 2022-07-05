package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D02_Login {

    P02_Login login = new P02_Login();

    public D02_Login() {
    }

//    @Given("user navigate to Home page")
//    public void user_navigate_to_Home_page() throws InterruptedException {
//        String url = "https://demo.nopcommerce.com/";
//        Hooks.driver.navigate().to(url);
//        Thread.sleep(2000L);
//    }

    @And("user click on login")
    public void clickLoginLink() throws InterruptedException {
        this.login.login_link().click();
        Thread.sleep(3000L);
    }

    @When("^user enter valid \"(.*)\" and valid \"(.*)\"$")
    public void enterValidEmailAndPassword(String email, String pass) {
        this.login.loginStep(email, pass);
    }

    @And("user clicks login button")
    public void clickLoginBtn() {
        this.login.LoginBtn().click();
    }

    @Then("user logged in successfully")
    public void assertSuccessfulLogin() throws InterruptedException {
        Thread.sleep(2000L);
        Assert.assertFalse(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/login?returnUrl=%2F/"));
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[href=\"/customer/info\"][class=\"ico-account\"]")).isDisplayed());
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[href=\"/logout\"][class=\"ico-logout\"]")).isDisplayed());
        soft.assertAll();
    }

    @Then("user could not login")
    public void assertFailedLogin() throws InterruptedException {
        Thread.sleep(1000L);
        String message = this.login.errorMessage().getText();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(message.contains("Login was unsuccessful. Please correct the errors and try again."));
        String sscolor = this.login.errorMessage().getCssValue("color");
        soft.assertEquals(sscolor, "#e4434b");
    }

}
