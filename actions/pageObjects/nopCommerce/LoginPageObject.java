package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	private WebDriverWait expliciWait;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPageObject(WebDriver driver, WebDriverWait expliciwait) {
		this.driver = driver;
		this.expliciWait = expliciwait;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	
		return new HomePageObject(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
	}
	
	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);	
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	
	
}
