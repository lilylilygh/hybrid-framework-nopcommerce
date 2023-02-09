package javaBasic;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// Switch case: Sẽ kiểm tra được trùng lặp
// Dễ hiểu hơn if-else và gọn đẹp code hơn
public class Topic_07_Switch_case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	@Parameters("browser")
	@Test
	public void TC_01(String browserName) {	
		driver = getBrowserDriver(browserName);
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
	}

	@Test
	public void TC_03_Ex3() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng này có 28 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày");
			break;
		default:
			System.out.println("Tháng vừa nhập sai định dạng!");
			break;
		}
	}

	@Test
	public void TC_03_Ex1() {
		/* Tên các chữ số nhập bằng TA: số nguyên 1-10
		 * a=1 -> Hiển thị One, 2 -> Two
		 */
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
		case 9:
			System.out.println("Nine");
		case 10:
			System.out.println("Ten");
		default:
			System.out.println("Error!");
			break;
		}
	}
		
	@Test
	public void TC_03_Ex2() {
		/* nhâp 2 số nguyên a b
		 * nhập phép toán +,-,*,/,%
		 * Thực hiện tính toán và in kết quả
		 */
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		String operator = scanner.next();
		switch (operator) {
		case "+":
			System.out.println("A + B = " + (numberA + numberB));
			break;
		case "-":
			System.out.println("A - B = " + (numberA - numberB));
			break;
		case "*":
			System.out.println("A x B = " + (numberA * numberB));
			break;
		case "/":
			System.out.println("A / B = " + (numberA / numberB));
			break;
		case "%":
			System.out.println("A % B = " + (numberA % numberB));
			break;
		}
	}

	@Test
	public void TC_04() {
		// Only convertible int values, strings or enum variables are permitted
		int studentPoint = scanner.nextInt();
		// enum variables = constant - Chỉ nhận int/ string/ enum
		// K dùng vs các toán tử trong case: = < > != ==
		// Với bài điểm số thì k dùng Switch case vì khó để đọc code, k check trùng lặp
		// -> Nên dùng if-else
	}
	
		public WebDriver getBrowserDriver(String browserName) {
		// Viết 1 hàm trả về tham số driver
		// Cách gọn code hơn
		// Note: Nếu có return thì k cần break - đều thoát khỏi vòng lặp
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe"); 
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe"); 
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe"); 
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.IE.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe"); 
			driver = new InternetExplorerDriver();
		default:
			new RuntimeException("Please input the correct the browser name");
			break;
		}
		return driver;
	}
	
	
}