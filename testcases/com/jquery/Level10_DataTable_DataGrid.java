package com.jquery;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.jQuery.DataTable.HomePageObject;
import pageObjects.jQuery.DataTable.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Table_01_Paging() {
		// Phân trang: Paging/Paginate
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("10"));
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("20"));
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("7"));
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActivated("18"));
	}

	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		
		homePage.enterToHeaderTextBoxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextBoxByLabel("Females", "338282");
		homePage.enterToHeaderTextBoxByLabel("Males", "349238");
		homePage.enterToHeaderTextBoxByLabel("Total", "687522");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextBoxByLabel("Country", "Angola");
		homePage.enterToHeaderTextBoxByLabel("Females", "276880");
		homePage.enterToHeaderTextBoxByLabel("Males", "276472");
		homePage.enterToHeaderTextBoxByLabel("Total", "553353");
		homePage.sleepInSecond(3);
	}

	@Test
	public void Table_03_Readfile_ToEnterToHeader() {
		// Đọc dữ liệu của file country.txt ra
		// Lưu vào 1 List<String> = Expected Value
		// Actual value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}
	
	@Test
	public void Table_04_Action_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(2);
		
		// Value để nhập liệu - tham số 1
		// Row number: tại row nào 
		// Ex: Nhap vao text box tai dong so 3/5/2
		// Column name: Company/ Contact Person/ Order Placed
		homePage.enterToTextBoxByColumnNameAtRowNumber("Company", "1", "Bogisich Group");
		homePage.sleepInSecond(3);
		
		homePage.enterToTextBoxByColumnNameAtRowNumber("Contact Person", "2", "Blondy Boggis");
		homePage.sleepInSecond(3);
		
		homePage.enterToTextBoxByColumnNameAtRowNumber("Order Placed", "3", "111");
		homePage.sleepInSecond(3);
		
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "6", "Taiwan");
		homePage.sleepInSecond(3);
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "8");
		
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		
		homePage.clickToIconByRowNumber("3", "Move Up");

		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
}
