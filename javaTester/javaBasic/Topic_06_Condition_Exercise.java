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

public class Topic_06_Condition_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	// Dùng scanner để nhập từ bàn phím
	Scanner scanner = new Scanner(System.in);

	@Test
	public void TC_01() {
		/* Kiểm tra n là số chẵn (chia hết cho 2) thì hiển thị:
		 *  n là số chẵn, ngược lại thì n là số lẻ
		 * -> n chia 2 dư = 0
		 */
		
		int number = scanner.nextInt();
		if(number % 2 == 0) {
			System.out.println("Số: " + number + " là số chẵn");
		} else {
			System.out.println("Số: " + number + " là số lẻ");
		}
	}

	@Test
	public void TC_02() {
		/* 2 số nguyên (interger) a & b
		 * a >= b -> Hiển thị "a lớn hơn hoặc bằng b"
		 * a <= b -> Hiển thị "a nhỏ hơn hoặc bằng b"
		 */
		
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		if (numberA >= numberB) {
			System.out.println(numberA + " lớn hơn hoặc bằng " + numberB);
		} else {
			System.out.println(numberA + " nhỏ hơn hoặc bằng " + numberB);
		}
	}

	@Test
	public void TC_03() {
		/* Kiểm tra xem tên của 2 ng giống nhau k
		 *  Có -> Hiển thị: "2 người là cùng tên"
		 *  Không -> Hiển thị: 2 người là khác tên
		 *  -> Dùng hàm equals cho String
		 */
		// Reference: String
		// Kiểm tra value của biến
		// Kiểm tra vị trí của biến trong vùng nhớ
		String studentA = scanner.nextLine();
		String studentB = scanner.nextLine();
		if (studentA.equals(studentB)) {
			System.out.println("Hai người cùng tên");
		} else
			System.out.println("Hai người khác tên");
		
		// Nếu dùng student A == student B -> Sẽ rơi vào "khác tên" nhau 
		// vì == dùng số thì đúng, nhưng text sẽ khác. Giá trị giống nhau nhưng vùng nhớ khác nhau
	}
	
	@Test
	public void TC_04() {
		/* Nhập 3 số nguyên a,b,c (Int)
		 * Hiển thị: số lớn nhất trong 3 số 
		 */
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		if (numberA > numberB && numberA > numberC) {
			System.out.println(numberA + " là số lớn nhất");
		} else if(numberB > numberC){
			System.out.println(numberB + " là số lớn nhất");
		} else {
			System.out.println(numberC + " là số lớn nhất");
		}		
	}
	
	@Test
	public void TC_05() {
		/* Kiểm tra số nguyên a có nằm trong đoạn [10,100) k:
		 *  Có -> Hiển thị: {P} nằm trong [10 - 100]
		 *  K -> Hiển thị: {P} k nằm trong [10 - 100]
		 */
		int numberA = scanner.nextInt();
		if (numberA > 10 && numberA < 100) {
			System.out.println(numberA + " nằm trong khoảng [10,100]");
		} else {
			System.out.println(numberA + " không nằm trong khoảng [10,100]");
		}
	}
	
	@Test
	public void TC_06() {
		/* Kiểm tra điểm nhập vào tương ứng xếp loại nào
		 * 0<5: D
		 * 5<7.5: C
		 * 7.5<8.5: B
		 * 8.5-10: A
		 * Điểm có thập phân -> float
		 */
		float studentPoint = scanner.nextFloat();
		if(studentPoint <= 10 && studentPoint >= 8) {
			System.out.println("Hệ số A");
		} else if(studentPoint < 8.5 && studentPoint >= 7.5) {
			System.out.println("Hệ số B");
		} else if (studentPoint < 7.5 && studentPoint >= 5) {
			System.out.println("Hệ số C");
		} else if (studentPoint < 5 && studentPoint >= 0){
			System.out.println("Hệ số D");
		} else {
				System.out.println("Bạn vui lòng nhập lại điểm");
		}
	}
	
	@Test
	public void TC_07() {
		/* Nhập tháng hiển thị số ngày của tháng đó
		 * Tháng 1,3,5,7,8,10,12 -> Hiển thị: 31
		 * Tháng 2 -> Hiển thị: 28 
		 * -> Dùng if-else -> dài, code k đẹp
		 * -> Switch case -> gọn
		 */
		int month = scanner.nextInt();
		if (month==1 || month==3 || month==5 || month==7
				|| month==8 || month==10) {
			System.out.println("Tháng này có 31 ngày");
		} else if (month==2) {
			System.out.println("Tháng này có 28 ngày");
		} else if (month==4 || month==6 || month==9 || month==11) {
			System.out.println("Tháng này có 30 ngày");
		}
	}
}