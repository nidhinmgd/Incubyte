package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateNewAccountPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public CreateNewAccountPage(WebDriver driver) {
	this.driver=driver;
	this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	By firstNameField=By.id("firstname");
	By lastNameField=By.id("lastname");
	By emailField=By.id("email_address");
	By passwordField=By.id("password");
	By confirmPasswordField=By.id("password-confirmation");
	By submitBtn=By.xpath("//span[text()='Create an Account']/parent::button");
	By message=By.xpath("//div[@role='alert']/div/div");
	By greetingMessage=By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]");
	By arrowBtn=By.xpath("//span[text()='Change']/parent::button");
	By signOutBtn=By.xpath("//span[@class='customer-name active']/following-sibling::div[@class='customer-menu']//a[contains(text(),'Sign Out')]");
	By invalidPassswordMsg=By.id("password-confirmation-error");
	By signoutMsg=By.xpath("//h1[@class='page-title']/span");
	
	public void enterFirstName(String fname) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
	}
	
	public void enterCfmPassword(String cpassword) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(cpassword);
	}
	
	public boolean passwordMatching(String pwrd,String cpwrd) {
		if(!pwrd.equals(cpwrd)) {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPassswordMsg)).isDisplayed();
		}
		return true;
	}
	
	public void clickSbumit() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn)).click();
	}
	
	public String getMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText().trim();
	}
	
	public String getGreetingMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(greetingMessage)).getText().trim();
	}
	
	public void verifyMessage(String expectedMsg) {
		Assert.assertEquals(getMessage(), expectedMsg);
	}
	
	public boolean verifyGreetMessage(String name) {
		System.out.println(getGreetingMessage());
		return getGreetingMessage().contains(name);
	}

	public String getSignoutMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(signoutMsg)).getText().trim();
	}

	public boolean verifySignOutMessage() {
		return getSignoutMessage().equals("You are signed out");
	}
	
	public void signOut() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(arrowBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(signOutBtn)).click();
	}
	

	
}
