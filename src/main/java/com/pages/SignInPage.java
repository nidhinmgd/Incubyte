package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By submitBtn = By.name("send");
    By getDetails = By.xpath("//div[@class='box-content']/p");

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void passwordField(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn)).click();
    }

    public void verifyUserData(String fname, String lname, String email) {
        String data = wait.until(ExpectedConditions.visibilityOfElementLocated(getDetails)).getText();
        String[] s = data.split("\n");
        Assert.assertEquals(s[0].trim(), fname + " " + lname);
        Assert.assertEquals(s[1].trim(), email);
    }

}
