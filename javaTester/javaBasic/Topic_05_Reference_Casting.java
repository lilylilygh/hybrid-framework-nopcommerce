package javaBasic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Topic_05_Reference_Casting {
	public String studentName;
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student name = " + studentName);
	}
	
	public static void main (String[] args) {
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
		
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		firstStudent.setStudentName("Nam");
		secondStudent.setStudentName("Quoc");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		// Ép kiểu Cast: 
		firstStudent = secondStudent;
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		secondStudent.setStudentName("Son");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		WebDriver driver = null;
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	}

}
