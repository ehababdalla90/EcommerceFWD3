package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_Register;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {

    P01_Register register = new P01_Register();

    public D01_Register() {
    }

    @Given("user navigate to home page")
    public void navigateHomepage() {
        String url = "https://demo.nopcommerce.com/";
        Hooks.driver.navigate().to(url);
    }

    @And("user click register")
    public void clickRegisterLink() {
        this.register.register_link().click();
    }

    @When("^user fills gender\"(.*)\" fname\"(.*)\" lname\"(.*)\" day\"(.*)\" month\"(.*)\" year\"(.*)\" email\"(.*)\" valid data$")
    public void fillPersonalData(String gender, String fname, String lname, String day, String month, String year, String email) throws InterruptedException {
        Thread.sleep(1000L);
        this.register.selectGenderType(gender).click();
        this.register.sendFirstName().sendKeys(new CharSequence[]{fname});
        this.register.last_name().sendKeys(new CharSequence[]{lname});
        Thread.sleep(1000L);
        Select selectDay = new Select(this.register.selectDay());
        selectDay.selectByVisibleText(day);
        Select selectMonth = new Select(this.register.selectMonth());
        selectMonth.selectByValue(month);
        Select selectYear = new Select(this.register.selectYear());
        selectYear.selectByVisibleText(year);
        this.register.email().sendKeys(new CharSequence[]{email});
    }

    @And("^user fills valid password \"(.*)\" confirm \"(.*)\"$")
    public void fillPassword(String pass, String confirm) {
        this.register.password().sendKeys(new CharSequence[]{pass});
        this.register.confirmPassword().sendKeys(new CharSequence[]{confirm});
    }

    @And("user clicks register button")
    public void clickRegisterBtn() throws InterruptedException {
        this.register.registerBtn().click();
        Thread.sleep(3000L);
    }

    @Then("success message is displayed")
    public void assertSuccessMessage() {
        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).isDisplayed());
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).isDisplayed());
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/registerresult/1?returnUrl=/"));
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[href=\"/customer/info\"][class=\"ico-account\"]")).isDisplayed());
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[href=\"/logout\"][class=\"ico-logout\"]")).isDisplayed());
        String message = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");
        soft.assertEquals(message, "rgba(76, 177, 124, 1)");
        soft.assertAll();
    }

}
