package javaBasic;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Class
public class Topic_09_While_Do_While_Array {
	static Scanner scanner = new Scanner(System.in);

	// Function
	public static void main(String[] args) {
		
//		int i = 0;
//		// Block code
//		// Chạy xong phần thân ms tăng 1 đơn vị
//		for (i = 0; i < 5; i++) {
//			System.out.println("For: " + i);
//		}
//
//		System.out.println("Biến i sau khi done vòng for: " + i);
//
//		// i = 5 -> K thỏa mãn đk -> While k chạy
//		while (i < 5) {
//			System.out.println("While: " + i);
//			i++;
//
//			// Do-while: Chạy ít nhất 1 lần kể cả đk sai r ms ktra điều kiện
//			// ít dùng
//		}
//		do {
//			System.out.println("Do-while: " + i);
//			i++;
//		} while (i < 5);
		
		TC_01_While();
	}
	
	@Test
	public static void TC_01_While() {
		/* Nhập số nguyên n và hiển thị số chẵn từ n->100
		 * ex: n =90 -> Hiển thị: 90 92 94 96 98 100
		 */
		int number = scanner.nextInt();
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}	
		}
	}
	@Test
	public static void TC_02_Do_While() {	
		int number = scanner.nextInt();
			do {
				if (number % 2 == 0) {
					System.out.println(number);
					number++;
				}
			} while (number <100);
		}
		

}