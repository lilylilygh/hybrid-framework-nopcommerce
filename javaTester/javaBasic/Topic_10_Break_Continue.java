package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Break_Continue {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		// Nested for
		for (int i = 1; i<=5; i++) {
			System.out.println("Lần chạy của i (for trên) = " + i);
			// i=1
			// Mỗi 1 lần chạy của for trên sẽ apply cho all lần chạy của for dưới
			for (int j=1; j<=5; j++) {
				// Loại trừ 1 đk này ra
				if (j==4) {
					continue;
				}
			System.out.println("j  = " + j);
			}
		}
	}
}