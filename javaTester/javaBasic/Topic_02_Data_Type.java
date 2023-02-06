package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Primitive type/value type: Nguyên thủy
	byte bNumber = 6;
	short sNumber = 1500;
	int iNumber = 65000;
	long lNumber = 65000;
	float fNumber = 15.98f;
	double dNumber = 15.98d;
	char cChar = '1';
	boolean bStatus = false;
	
	// Non-primitive/ Reference type: Tham chiếu
	// String
	String addres = "Ho Chi Minh";
	
	// Array: 1 mảng 1 kiểu dữ liệu
	String[] studentAddress = {addres,"Hanoi", "Da Nang"};
	Integer[] studentNumber = {15, 20, 50};
	// Tupe: 1 mảng nhiều kiểu dữ liệu
	
	// Class: topic là 1 biến đại diện cho Topic_02
	Topic_02_Data_Type topic;
	// Interface
	WebDriver driver;
	// Object
	Object aObject;
	// Collection
	// List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	List<String> productName = new ArrayList<String>();
	
	Set<String> allWindows = driver.getWindowHandles();
	
	public void clickToElement() {
		addres.trim();
		studentAddress.clone();
		driver.getCurrentUrl();
		aObject.toString();
		homePageLinks.size();
		allWindows.clear();
		
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		topic.addres = "Ha Noi";
		
	}
	
	public static void main(String[] args) {
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	---------------------------------------------------------------------
	// Ex: Global variable
//	static int number;
//
//	String address = "HCM";
//
//	public static void main(String[] args) {
		// Local variable
//		int StudentNumber = 0;
//		System.out.println(StudentNumber);

		// Cách làm đúng với address HCM
		// Khai báo 1 object mới
//		Topic_02_Data_Type topic = new Topic_02_Data_Type();
//		System.out.println(topic.address);
//
//		System.out.println(number);
//	}
//}
