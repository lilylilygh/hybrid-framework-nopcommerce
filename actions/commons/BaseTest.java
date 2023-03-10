package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {
	private WebDriver driverBaseTest;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driverBaseTest = new FirefoxDriver();
			// Headless dung cho Frontend de run Unit Test/Data Analyst/MMO (Crawl Data)
			// Headless chạy ngầm, k bật giao diện trình duyệt lên
		} else if (browserName.equals("h_firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

			// Browser Option: selenium 3.xx
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);

		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driverBaseTest = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			System.setProperty("webdriver.opera.driver", projectPath + "\\browserDrivers\\operadriver.exe");
			driverBaseTest = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			// Cốc cốc browser trừ đi 5-6 version -> ra ChromeDriver
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver_93.exe");
			ChromeOptions options = new ChromeOptions();

			options.setBinary("C:\\Program files(86)\\CocCoc\\Browser\\Application\\browser.exe");

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

		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverBaseTest.get("https://demo.nopcommerce.com/");
		return driverBaseTest;
	}
}
