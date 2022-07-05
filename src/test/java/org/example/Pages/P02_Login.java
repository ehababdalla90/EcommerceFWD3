package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_Login {

    public WebElement login_link(){
        By register=By.className("ico-login");
        return Hooks.driver.findElement(register);
    }
    public WebElement Email()
    {
        By email = By.name("Email");
        WebElement Email = Hooks.driver.findElement(email);
        return Email;
    }

    public WebElement Password()
    {
        By password = By.id("Password");
        WebElement Password = Hooks.driver.findElement(password);
        return Password;

    }
    public  WebElement LoginBtn()
    {
        By login = By.cssSelector("button[class=\"button-1 login-button\"]");
        WebElement LogIn = Hooks.driver.findElement(login);
        return LogIn;
    }
    public void loginStep(String user,String pass){
        Email().clear();
        Email().sendKeys(user);
        Password().sendKeys(pass);
    }

    public WebElement errorMessage(){

        WebElement errorMessage= Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
        return errorMessage;
    }

}
