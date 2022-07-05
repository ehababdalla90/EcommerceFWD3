package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P03_ForgotPassPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D03_ForgotPassDef {
    P03_ForgotPassPage forget=new P03_ForgotPassPage();

//    @Given("user navigate to Login page")
//    public void user_navigate_to_Login_page(){
//        String url = "https://demo.nopcommerce.com/login?returnUrl=%2F";
//        Hooks.driver.navigate().to(url);
//    }

    @And("user click on forgot password")
    public void user_click_on_forgot_password() throws InterruptedException {
        Thread.sleep(4000);
        forget.forgotPassBtn().click();
        Thread.sleep(4000);
    }

    @And("^user enter his \"(.*)\"$")
    public void user_enter_his_email(String email){
        forget.emailField().sendKeys(email);
    }

    @And("user click on recovery")
    public void user_click_on_recovery() throws InterruptedException {
        forget.clickRecoverBtn().click();
        Thread.sleep(5000);
    }

    @Then("email is sent to the user")
    public void email_is_sent_to_the_user(){
        String ExpectedResult = "Email with instructions has been sent to you.";
        String ActualResult =Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]")).getText();
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
        System.out.println("Password Recovery Message: \"Email with instructions has been sent to you.\" is displayed");
    }
}
