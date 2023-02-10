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
		
		Topic_09_While_Do_While_Array topic = new Topic_09_While_Do_While_Array ();
		topic.TC_03_Ex6();
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
			}
			number++;
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
		
	@Test
	public static void TC_03_Ex2() {
		/* 2 số nguyen a b
		 * Hiển thị các số từ a->b % 3 & 5 == 0
		 * Ex: a=1, b=50 -> Hiển thị: 15,30,45
		 */
		int numberA = scanner.nextInt();
		
		while (numberA < 100) {
			// chia hết cho cả 3 và 5
			if (numberA % 3 == 0 && numberA % 5 == 0) {
				System.out.println(numberA);
			}	
			// cho ra ngoài mới thoát đc vòng lặp
			numberA++;
		}
	}
	
	@Test
	public static void TC_03_Ex3() {
		/* số nguyên n
		 * Hiển thị tổng các số lẻ từ 0 -> n
		 * Ex: n=7 -> Hiển thị màn hình 16 = 1+3+5+7 
		 */
		int numberA = scanner.nextInt();
		int i = 0;
		while (numberA > 0) {
			if (numberA % 2 != 0) { //số lẻ
				i +=numberA; // i = i+numberA
			}	
			// cho ra ngoài mới thoát đc vòng lặp
			numberA--;
		}
		System.out.println(i);
	}
	
	@Test
	public static void TC_03_Ex5() {
		/* số nguyên n
		 * Hiển thị n!(n giai thừa)
		 * Ex: n =5 -> hiển thị 120 = 1*2*3*4*5
		 */
		int numberA = scanner.nextInt();
		int i = 1;
		while (numberA > 0) {
			i *= numberA;
			numberA--;
		}
		System.out.println(i);	
	}
	@Test
	public static void TC_03_Ex6() {
		/*
		 * in ra console tổng sỗ chẵn từ số nguyên 1->10
		 */
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			if (i % 2 == 0) {
				sum += i;
			}
			i++;
			System.out.println("Tong các số chẵn từ 1 đến 10: " + sum);
		}
	}
}