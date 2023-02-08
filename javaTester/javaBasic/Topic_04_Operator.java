package javaBasic;

import org.testng.Assert;

public class Topic_04_Operator {

	public static void main(String[] args) {
		int number = 10;
		number += 5;  // mean: number = number + 5;
		System.out.println(number);
		
		// 15/5 = 3
		System.out.println(number / 5);
	
		// 15%6 = 2 dư 3 - % lấy dư
		System.out.println(number % 6);
		
		// in number ra trc: 10
		// ++ sau = tăng number lên 1 = 11
		System.out.println(number++);
		
		// ++ trước = tăng number lên 1 = 12
		// in number ra sau = 12
		System.out.println(++number);
		
		for (int i = 0; i<3; i++) {
			System.out.println(i);
			// -> in ra 0,1,2
			// đổi ++i -> KQ vẫn là 0,1,2
		}
		Assert.assertTrue (5<6);
		String address = "HCM";
		if (address != "HN") {
			System.out.println("Address is not the same");
		}
		
		// Biểu thức tam nguyên: = ? :
		boolean status = (address == "HN") ? true : false; //Nếu address HN đúng thì True và k đúng thì False
		System.out.println(status);
		// -> KQ là False vì address k phải HN
	}

}
