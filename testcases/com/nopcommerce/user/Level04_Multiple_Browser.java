package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level04_Multiple_Browser extends BaseTest {
	// private chỉ dùng trong class này, k chia sẻ
	// Declare
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	// Decalre + Init
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);		
		
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		firstName = "Automation";
		lastName = "Linh";
		emailAddress = "abc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage.clicktoRegisterLink();

		// Click Register link -> Nhảy qua trang Register
		//registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@456!@#$");
		registerPage.inputToPaswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		homePage.clicktoRegisterLink();

		// Click Register link -> Nhảy qua trang Register
		//registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPaswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		homePage.clicktoRegisterLink();

		// Click Register link -> Nhảy qua trang Register
		//registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPaswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(emailAddress);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
