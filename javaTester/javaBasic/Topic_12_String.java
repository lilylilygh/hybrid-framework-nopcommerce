package javaBasic;

import org.openqa.selenium.Keys;

public class Topic_12_String {
	public static void main(String[] args) {
		String schoolName = "Automation Testing";
		String courseName = schoolName.toLowerCase();
		
		String schoolAddress = "Ho Chi Minh City";
		
		System.out.println("Độ dài = " + schoolName.length());
		System.out.println("Lấy ra 1 kí tự = " + schoolName.charAt(0));
		System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi = " + schoolName + schoolAddress);
		
		// Tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(courseName));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals("Automation Testing"));
		
		// Multi browser
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equalsIgnoreCase(courseName));
		
		// startswith/ endswith/ contains
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("A"));
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("Automation"));
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("T"));
		
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("Automation"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("T"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("Testing"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("Advanced"));
		
		System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.endsWith("g"));
		System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.endsWith("Testing"));
		System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.endsWith("Automation"));
		
		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("utomation"));
		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("A"));
		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("Testing"));
		
		System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.substring(11));
		System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.substring(11, 15));
		
		
		// Split: Tách chuỗi thành 1 mảng dựa vào kí tự/ chuỗi kí tự
		// Alert
		String result = "Viewing 48 of 132 results";
		String results[] = result.split(" ");
		System.out.println(results[1]);
		
		// Replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);
		
		// Sắp xếp nó: Sort Data (Asc/Desc)
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);
		
		productPrice = String.valueOf(productPriceF);
		System.out.println(productPrice);
		
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		// Wins 10 
		// Handle multiple os: MAC/ Windows(Actions keys Ctrl/Command)
		if (osName.toLowerCase().contains("windows")) {
			Keys key = Keys.CONTROL;
		} else {
			Keys key = Keys.COMMAND;
		}
		
		// Multiple browser: toUpperCase
		// firefox = FIREFOX (Enums)
		
		// String driverInstanceName = driver.toString();
		// System.out.println(driverInstanceName);
		// firefoxDriver: firefox on WINDOWS 
		// Close browser/ driver
		// if (driverInstanceName.contains("internetexplorer")){
		// Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
		// }
		
		// Khoảng trắng/ xuống dòng/ tab
		String helloworld = " \n \t		Hello world!		";
		System.out.println(helloworld);
		System.out.println(helloworld.trim());
		
		helloworld = " ";
		
		System.out.println("Empty = " + helloworld.isEmpty());
		System.out.println("Blank = " + helloworld.isBlank());
		
		
		// Dynamic Locator
		// Đại diện cho 1 chuỗi: %s
		// %b %L %d
		String dynamicButtonXpath = "//button[@id='%s']";
		System.out.println("Click to Login button = " + String.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Login button = " + String.format(dynamicButtonXpath, "search"));
		System.out.println("Click to Login button = " + String.format(dynamicButtonXpath, "register"));		
	}
}
