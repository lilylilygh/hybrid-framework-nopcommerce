package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driverBaseTest;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			driverBaseTest = WebDriverManager.firefoxdriver().create();
			// Headless dung cho Frontend de run Unit Test/Data Analyst/MMO (Crawl Data)
			// Headless chạy ngầm, k bật giao diện trình duyệt lên
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();

			// Browser Option: selenium 3.xx
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);

		} else if (browserName.equals("chrome")) {
			driverBaseTest = WebDriverManager.chromedriver().create();
		} else if (browserName.equals("h_chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driverBaseTest = WebDriverManager.edgedriver().create();
		} else if (browserName.equals("opera")) {
			driverBaseTest = WebDriverManager.operadriver().create();
		} else if (browserName.equals("coccoc")) {
			// Cốc cốc browser trừ đi 5-6 version -> ra ChromeDriver
			WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			ChromeOptions options = new ChromeOptions();

			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program files(86)\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				options.setBinary("....");
			}
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("brave")) {
			// Brave browser version nào dùng chromedriver version đó
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver_95.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driverBaseTest = new ChromeDriver();
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL);
		return driverBaseTest;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		if (browserName.equals("firefox")) {
			driverBaseTest = WebDriverManager.firefoxdriver().create();
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driverBaseTest = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			// Cốc cốc browser trừ đi 5-6 version -> ra ChromeDriver
			WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			ChromeOptions options = new ChromeOptions();
				options.setBinary("C:\\Program files(86)\\CocCoc\\Browser\\Application\\browser.exe");
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("brave")) {
			// Brave browser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("95.0.4638.1/").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driverBaseTest = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.get(appUrl);
		return driverBaseTest;
	}

//	protected String getEnvironmentUrl (String serverName) {
//		String envUrl = null;
//		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
//		if (environment = EnvironmentList.DEV) {
//			envUrl = "https://demo.nopcommerce.com/";
//		}
//		return envUrl;
//	}
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
