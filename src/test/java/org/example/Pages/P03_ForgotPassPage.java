package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P03_ForgotPassPage {

    public WebElement forgotPassBtn(){

        WebElement forgetPasswordBtn= Hooks.driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]"));
        return forgetPasswordBtn;
    }

    public WebElement emailField(){
        WebElement Email=Hooks.driver.findElement(By.cssSelector("input[class=\"email\"]"));
        return Email;
    }

    public WebElement clickRecoverBtn(){

        WebElement recovery=Hooks.driver.findElement(By.cssSelector("button[name=\"send-email\"]"));
        return recovery;
    }
}
