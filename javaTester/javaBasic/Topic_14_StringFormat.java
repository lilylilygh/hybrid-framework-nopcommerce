package javaBasic;

public class Topic_14_StringFormat {
	// Final: k cho ghi de, gan du lieu lai 
	// 14 pages = 14 bien locator
	public static String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	
	// 1 bien cho ca 14 or n page (format giong nhau, ten page khac nhau)
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";

	// 1 locator để đại diện cho các page (Header/Sidebar/ Footer)
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";
	
	public static void main(String[] args) {
		// Cach 1
//		clickToLink(CUSTOMER_INFO_LINK);
//		clickToLink(ADDRESS_LINK);
//		clickToLink(MY_PRODUCT_REVIEW_LINK);
//		clickToLink(REWARD_POINT_LINK);
		
		// Cach 2
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Customer info");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Addresses");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "My product reviews");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Reward points");
	
		// Cach 3
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Addresses");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper", "Search");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "header-upper", "My Account");
	}
	
	public static void clickToLink(String locator) {
		System.out.println("Click to: " + locator);
	}
	// 1 tham số động
//	public static void clickToLink(String dynamicLocator, String pageName) {
//		String locator = String.format(dynamicLocator, pageName);
//		// dynamicLocator = //div[contains(@class,'account-navigation')]//a[text()='%s']
//		// pageName = Customer info
//		// %s: pattern de thay the cho 1 tham so kieu String
//		System.out.println("Click to: " + locator);
//	}
//	// 2 tham số động
//	public static void clickToLink(String dynamicLocator, String areaName, String pageName) {
//		String locator = String.format(dynamicLocator, areaName, pageName);
//		System.out.println("Click to: " + locator);
//	}
	
	// 1-n tham số động
	public static void clickToLink(String dynamicLocator, String...params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
	}
	
}
