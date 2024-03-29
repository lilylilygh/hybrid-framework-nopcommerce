package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BasePageFactory;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level03_Page_Object_02_Login extends BasePage {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);
		firstName = "Automation";
		lastName = "Linh";
		invalidEmail = "auto@auto.com@.vn";
		existingEmail = "abc" + generateFakeNumber() + "@mail.vn";
		notFoundEmail = "abc" + generateFakeNumber() + "@mail.com";
		validPassword = "123456";
		incorrectPassword = "6543835";

		System.out.println("Pre-condition - Step 01:Click to Register link");
		homePage.clicktoRegisterLink();

		// Click Register link -> Nhảy qua trang Register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Pre-condition - Step 02:Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPaswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-condition - Step 03:Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition - Step 04:Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - Step 05:Click to Logout link");
		registerPage.clicktoLogoutLink();

		// Logout -> Nhảy qua trang Homepage
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		// homePage
		homePage.openLoginPage();

		// Home -> click Login -> LoginPage khởi tạo
		loginPage = new UserLoginPageObject(driver);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	public void Login_03_Email_Not_Found() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	public void Login_04_Existing_Email_Empty_Password() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	public void Login_06_Valid_Email_Password() {
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		// Login success -> Return to Homepage
		homePage = new UserHomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
