package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level07_Switch_Page_UI extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "Automation";
		lastName = "Linh";
		emailAddress = "abc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
		}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clicktoRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToPaswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clicktoLogoutLink();
	}

	public void User_02_Login() {
		loginPage = homePage.openLoginPage();
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	public void User_03_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink(driver);
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	public void User_04_Switch_Page() {
		/* Knowledge của Page Object:
		* Một page A -> B thì phải viết 1 hàm 
		* action: open/click/...:link/button/image/.. để mở page B lên
		*/
		
		// Customer Info -> Address
		addressPage = customerInfoPage.openAddressPage(driver);
		
		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		
		// My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		
		// Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		
		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		// Reward Point -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
		// My Product Review -> Address
		addressPage = myProductReviewPage.openAddressPage(driver);
		
		customerInfoPage = addressPage.openCustomerInfoPage(driver);
	}
	
	public void User_05_Switch_Role() {
		// Role User -> Admin
		
		// Admin -> User
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	private String firstName, lastName, emailAddress, validPassword;

}
