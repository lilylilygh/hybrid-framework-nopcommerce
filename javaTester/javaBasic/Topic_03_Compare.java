package javaBasic;

public class Topic_03_Compare {
	int numbers = 8;

	public static void main(String[] args) {
		// 1 vùng nhớ cho biến x
		int x = 5;

		// 1 vùng nhớ cho biến y
		int y = x;

		System.out.println("x = " + x);
		System.out.println("y = " + y);

		y = 10;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		// -> Khi y=10 thì x vẫn bằng 5
		// Vì 2 thằng là 2 vùng nhớ khác biệt, độc lập

		// Nếu kiểu dữ liệu tham chiếu int numbers thì sẽ khác
		Topic_03_Compare firstVariable = new Topic_03_Compare();

		Topic_03_Compare secondVariable = firstVariable;
		// Nếu k dùng tham chiếu thì phải set new cho secondVariable
		System.out.println("Before =" + firstVariable.numbers);
		System.out.println("Before =" + secondVariable.numbers);
		// -> KQ first & sec = 8

		// Set sec = 15
		secondVariable.numbers = 15;
		System.out.println("After =" + firstVariable.numbers);
		System.out.println("After =" + secondVariable.numbers);
		// -> KQ first & sec = 15 vì là kiểu dữ liệu tham chiếu
	}
}
