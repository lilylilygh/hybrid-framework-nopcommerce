package javaBasic;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Topic_01_Variable {

	// Hàm khởi tạo
	public Topic_01_Variable() {
		// Biến toàn cục
		String studentName;
	}

	static int studentNumber;
	static boolean statusValue;
	static final String BROWSER_NAME = "Chrome"; // Hằng số constant "BROWSER_NAME" cần phải viết hoa

	static int studentPrice;

	String studentName = "Lily";

	public static void main(String[] args) {
		int studentPrice = 5;

		System.out.println(studentPrice);

		System.out.println(studentNumber);
		System.out.println(statusValue);
		// Khi bắt đầu run 1 chương trình, đc sinh ra và chỉ bị hủy khi chương trình k
		// còn tồn tại/ mất đi
		System.out.println(Topic_01_Variable.BROWSER_NAME);
		System.out.println(Topic_01_Variable.statusValue);
		System.out.println(Topic_01_Variable.studentPrice);

		Topic_01_Variable topic = new Topic_01_Variable();
		System.out.println(studentNumber);

	}

	// Getter: getCurrentURL/Title/Text/Attribute/CssValue/Size/Location/... (data)
	public String getStudentNumber() {
		return this.studentName;
	}

	// Setter: click/sendkey/clear/select/back/forward/refresh/get/... (actions)
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
