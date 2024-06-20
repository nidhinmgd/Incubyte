package com.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
	this.driver=driver;
	this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	By createNewAcctBtn=By.linkText("Create an Account");
	By signInBtn=By.partialLinkText("Sign In");
	
	public void clickCreateNewAccountButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(createNewAcctBtn)).click();
	}
	
	public void clickSignInButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn)).click();
	}
}
