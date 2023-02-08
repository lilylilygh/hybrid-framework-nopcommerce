package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

public class Topic_06_If_Else {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Test
	public void TC_01_If() {
		boolean status = 5 < 3;
		System.out.println(status);

		// Hàm if sẽ nhận vào 1 điều kiện đúng
		// Kiểm tra duy nhất 1 điều kiện
		// Nếu điều kiện này đúng thì sẽ action (xxx) trong body
		if (status) {
			// Đúng thì vào body của if
			// Sai thì bỏ qua
			System.out.println("Go to if");
		}

		// = Gán (assign)
		int studentNum = 10;

		// == dùng để so sánh
		status = (studentNum == 10);
		System.out.println(status);

		WebDriver driver = new FirefoxDriver();
		WebElement salePopup = driver.findElement(By.id(""));
		// Element luôn có trong DOM dù popup có hiển thị hay k
		if (salePopup.isDisplayed()) {

		}

		// Element k có trong DOM khi popup k hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));

		// Check Element k hiển thị
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {

		}

		// Uncheck to checkbox: hàm phủ định
		WebElement langCheckbox = driver.findElement(By.id(""));
		if (langCheckbox.isSelected()) {
			langCheckbox.click();
		}

		// Check to checkbox
		WebElement languageCheckbox = driver.findElement(By.id(""));
		if (!languageCheckbox.isSelected()) {
			languageCheckbox.click();
		}		
	}
	
	@Test
	public void TC_02_If_Else() {
		// Có tới 2 đk: Nếu đúng thì vào if - sai vào else
		
		// Nếu driver start vs browser như Chrome/Firefox/Edge/Safari 
		// -> Dùng builtin của Selenium WebElement
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe"); //trỏ đến file geckodriver.exe
		driver = new FirefoxDriver();
		System.out.println(driver.toString());
		
		// Nếu driver start vs IE -> dùng hàm click của javascriptExecutor
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		if(driver.toString().contains("inter explorer")) {
			System.out.println("Click by Javascript Executor");
		} else {
			System.out.println("Click by Selenium WebElement");
		}
		
	}	
	@Parameters("browser")
	@Test
	public void TC_03_If_Else_If_else(String browserName) {
		// Có nhiều điều kiện
		// Best practice: k nên if else quá nhiều
		// Vì code xấu, khó bảo trì sau này -> Tối ưu hóa có thể nhét ra từng class
		
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe"); 
			driver = new FirefoxDriver();	
		} else if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe"); 
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe"); 
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.IE.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe"); 
			driver = new InternetExplorerDriver();
		} else { // Sẽ gọi Safari/Opera/Cococ..
			throw new RuntimeException("Please input the correct the browser name");
		}
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		
		driver.quit();
	}
	
	@Test
	public void TC_04_If_Else_If_Else() {
		// Page Object
		// Dynamic Page
		
		String pageName = "Login";
		if (pageName.equals("Login")) {
			// LoginPage loginPage = new LoginPage();
			// return loginPage;
		} else if (pageName.equals("Register")) {
			// Register registerPage = new RegisterPage();
			// return registerPage;
		} else {
			// Homepage homePage = new HomePage();
			// return homePage;
		}
		
		// Tránh bị trùng Login và Register page thì có thể dùng switch case
		
		// If-else
		int age = 20;
		// Cách viết gọn hơn
		String access = (age < 18) ? "You can not access" : "Welcome to our system!";
		// Cách dài hơn
		if (age< 18) {
			access = "You can not access"; 
			System.out.println("You can not access"); 
		} else {
			access = "Welcome to our system!"; 
			System.out.println("Welcome to our system!");
		}
		// -> Cách access gọn hơn (Dùng tam nguyên), sysout thì dài hơn
	}
	
	public static void main(String[] args) {
		
	}
}


