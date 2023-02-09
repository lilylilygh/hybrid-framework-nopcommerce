package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_For_ForEach {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Test
	public void TC_01_For() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		// Vế 1: biến tạm dùng để tăng giá trị lên sau mỗi lần duyệt
		// Dùng để so sánh với tổng giá trị
		// Vế 2: So sánh vs tổng
		// Vế 3: Tăng i lên 1 đơn vị sau khi chạy vào thân vòng for
		// Lần 1: i = 0, 0<5: đúng, in 0 -> sau đó i++ tăng lên 1 đơn vị -> i=1
		// Lần 2,3,4,5 tương tự
		// Lần 6: i = 5, 5<5: sai, thoát khỏi vòng for
		System.out.println("==============");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
		
		// Array/ List/ Set/ Queue (Index)
		// Luôn luôn tính từ 0

		String[] cityName = { "Hanoi", "Ho Chi Minh", "Da Nang", "Can Tho" };
		// for (int i = 0; i < cityName.length; i++) {
		// System.out.println(cityName[i]);}

		// Có thể dùng for if: thỏa mãn điều kiện mới action
		// Biển đếm - dùng như điều kiện để filter
		for (int i = 0; i < cityName.length; i++) {
			if(cityName[i].equals("Hanoi")) {
				// Action
				System.out.println("Do action");
				break;
				// dùng break thì thoát luôn vòng lặp khi đã thỏa mãn đk
				// k dùng break thì sẽ chạy tất cả các giá trị element dù đã thỏa mãn đk
			}
		}
	}

	@Test
	public void TC_02_Foreach() {
		// Đọc code dễ hiểu hơn for
		// 1 người trung chuyển để duyệt qua
		// Foreach dùng cho Array/Collections
		String[] cityName = { "Hanoi", "Ho Chi Minh", "Da Nang", "Can Tho" };
		for (String city : cityName) {
			System.out.println(city);
		}
		System.out.println("===============");
		// Java Collection
		// Class: ArrayList/ LinkedList/ Vector/...
		// Interface: List/Set/Queue
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		
		// Compile (Coding)
		cityAddress.add("Bac Giang");
		cityAddress.add("Ha Giang");
		cityAddress.add("Sa Pa");
		System.out.println(cityAddress.size());
		
		// Runtime (Running)
		for (String city : cityName) {
			cityAddress.add(city);
		}
		System.out.println(cityAddress.size());
		System.out.println("===============");
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}
		
		// Java Generic
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		// Xử lí dữ liệu/ get text/ value/ css/ attribute
		for (WebElement link : links) {
			// chuyển Page
			// Refresh Dom/HTML
			// K còn tồn tại
			// Fail -> StaleElementException
		}
		
		// Sort
		
		// Note: foreach k chạy ngược đc nhưng for thì được
	}	

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}