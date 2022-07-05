package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_Register {



    public WebElement register_link() {
        By register = By.className("ico-register");
        WebElement reg = Hooks.driver.findElement(register);
        return reg;
    }

    public WebElement selectDay() {
        WebElement day = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        return day;
    }

    public WebElement selectMonth() {
        WebElement month = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        return month;
    }

    public WebElement selectYear() {
        WebElement year = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        return year;
    }

    public WebElement selectGenderType(String type) {
        WebElement gender = null;
        if (type.equals("male")) {
            gender = Hooks.driver.findElement(By.cssSelector("input[type=\"radio\"][id=\"gender-male\"]"));
        } else if (type.equals("female")) {
            gender = Hooks.driver.findElement(By.cssSelector("input[type=\"radio\"][id=\"gender-female\"]"));
        }

        return gender;
    }

    public WebElement sendFirstName() {
        WebElement firstName = Hooks.driver.findElement(By.cssSelector("input[id^=\"FirstName\"]"));
        return firstName;
    }

    public WebElement last_name() {

        WebElement lastName = Hooks.driver.findElement(By.cssSelector("input[id^=\"LastName\"]"));
        return lastName;
    }

    public WebElement email() {

        WebElement email = Hooks.driver.findElement(By.cssSelector("input[id^=\"Email\"]"));
        return email;
    }

    public WebElement password() {
        WebElement password = Hooks.driver.findElement(By.cssSelector("input[id^=\"Password\"]"));
        return password;
    }

    public WebElement confirmPassword() {

        WebElement confirmPassword = Hooks.driver.findElement(By.cssSelector("input[id^=\"ConfirmPassword\"]"));
        return confirmPassword;
    }

    public WebElement registerBtn() {
        WebElement registerBtn = Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"][id=\"register-button\"]"));
        return registerBtn;
    }

}
