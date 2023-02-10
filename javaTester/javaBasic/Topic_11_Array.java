package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Array {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		// Array là lưu trữ cùng kiểu dữ liệu 
		// Tupe là lưu trữ nhiều kiểu dữ liệu khác nhau 
		// Khai báo trong java
		// int number[] = {12, 7, 5, 6, 16};
		// int []student = {12, 7, 5, 6, 16};
		
		// Lấy ra phần tử đầu tiên [0], lấy element phải dùng index
		// System.out.println(student[0]);
		// Nếu System.out.println(student[6]); -> Fail -> Index out of bounds
		
		// Được define cố định phần tử từ khi mình viết code (Compile)
		String studentName[] = {"Nam", "Long", "An"};
		// Có thể gán lại được: studentName[0] = "Hoa";
		
		for (int i=0; i<studentName.length; i++) {
			if(studentName[i].equals("Long")) { // hoặc if(i==2){ 
			System.out.println("Click vào Long");
			}
		}
		// foreach: Ko kết hợp vs điều kiện
		for (String std:studentName) {
			if(std.equals("Long")) { 
				System.out.println("Click vào Long");
			}
		}
		
		// ArrayList có thể thêm,sửa,xóa. Còn Array thì k
		ArrayList<String> stdName = new ArrayList<String>();
		// Khi chạy code mới add (Runtime)
		for (String std:studentName) {
			stdName.add(std);
		}
		
		List<String> names = Arrays.asList("Tom", "Jerry", "Donal");
		for (String name: names) {
			System.out.println("Name: " + name);
		}
	}
}