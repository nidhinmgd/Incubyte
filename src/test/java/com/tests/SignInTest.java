package com.tests;

import com.incubyte.utils.CustomDataprovider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.incubyte.utils.Drivers;
import com.pages.CreateNewAccountPage;
import com.pages.HomePage;
import com.pages.SignInPage;

public class SignInTest extends Drivers{
	WebDriver driver;
	@Test(dataProvider ="TC_01",dataProviderClass = CustomDataprovider.class )
	public void TC01_SignUp(String fname,String lname,String email,String password,String cPassword) {
		HomePage homepage = new HomePage(driver);
		homepage.clickCreateNewAccountButton();
		CreateNewAccountPage  newPage=new CreateNewAccountPage(driver);
		newPage.enterFirstName(fname);
		newPage.enterLastName(lname);
		newPage.enterEmail(email);
		newPage.enterPassword(password);
		newPage.enterCfmPassword(cPassword);
		newPage.clickSbumit();
		Assert.assertTrue(newPage.passwordMatching(password, cPassword));
		newPage.verifyMessage("Thank you for registering with Main Website Store.");
		Assert.assertTrue(newPage.verifyGreetMessage(fname+" "+lname));
		Assert.assertTrue(newPage.verifySignOutMessage());
	}

	@Test(dataProvider ="TC_01",dataProviderClass = CustomDataprovider.class )
	public void TC02_SignIn(String fname,String lname,String email,String password) {
		HomePage homepage = new HomePage(driver);
		homepage.clickSignInButton();
		SignInPage signin =new SignInPage(driver);
		signin.enterEmail(email);
		signin.passwordField(password);
		signin.clickSignIn();
		CreateNewAccountPage newPage=new CreateNewAccountPage(driver);
		Assert.assertTrue(newPage.verifyGreetMessage(fname+" "+lname));
		signin.verifyUserData(fname,lname,email);
		newPage.signOut();
		Assert.assertTrue(newPage.verifySignOutMessage());
	}

	@Test(dataProvider ="TC_01",dataProviderClass = CustomDataprovider.class )
	public void TC03_InvalidSignUp(String fname,String lname,String email,String password,String cPassword) {
		HomePage homepage = new HomePage(driver);
		homepage.clickCreateNewAccountButton();
		CreateNewAccountPage  newPage=new CreateNewAccountPage(driver);
		newPage.enterFirstName(fname);
		newPage.enterLastName(lname);
		newPage.enterEmail(email);
		newPage.enterPassword(password);
		newPage.enterCfmPassword(cPassword);
		newPage.clickSbumit();
		Assert.assertTrue(newPage.passwordMatching(password, cPassword));
	}

	@Test(dataProvider ="TC_01",dataProviderClass = CustomDataprovider.class )
	public void TC04_InvalidSignIn(String email,String password) {
		HomePage homepage = new HomePage(driver);
		homepage.clickSignInButton();
		SignInPage signin =new SignInPage(driver);
		signin.enterEmail(email);
		signin.passwordField(password);
		signin.clickSignIn();
		CreateNewAccountPage newPage=new CreateNewAccountPage(driver);
		newPage.verifyMessage("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}

	@BeforeTest
	public void before() {
		Drivers drivers=new Drivers();
		driver=drivers.getDriver();
	}

	@AfterTest
	public void after() {
		driver.quit();
	}
}
