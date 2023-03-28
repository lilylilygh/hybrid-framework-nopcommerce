package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String emailAddress) {
		waitForElementInVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementInVisible(driver, AdminLoginPageUI.PASWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASWORD_TEXTBOX, password);
	}

	public AdminDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
	
	public AdminDashBoardPageObject loginAsAdmin(String emailAddress, String password){
		inputToUsernameTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
	
}
