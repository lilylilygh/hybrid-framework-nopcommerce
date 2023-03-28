package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage{
	// Biến global
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
	// Biến local
		this.driver = driver;
	}
	
	public UserRegisterPageObject clicktoRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		// Cach 2: return new RegisterPageObject(driver);
		// Cach 3:
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink(WebDriver driver) {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}


	
	
	
	
}
