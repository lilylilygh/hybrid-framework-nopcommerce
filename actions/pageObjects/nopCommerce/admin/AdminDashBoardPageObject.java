package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminDashBoardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
	}
}
