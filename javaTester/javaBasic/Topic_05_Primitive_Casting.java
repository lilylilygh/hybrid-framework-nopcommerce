package javaBasic;

public class Topic_05_Casting {

	public static void main(String[] args) {
		// Ép kiểu ngầm định: K  mất dữ liệu
		byte bNumber = 126;
		System.out.println(bNumber);
		short sNumber = bNumber;
		System.out.println(sNumber);
		int iNumber = sNumber;
		System.out.println(iNumber);
		long lNumber = iNumber;
		System.out.println(lNumber);
		float fNumber = lNumber;
		System.out.println(fNumber);
		double dNumber = fNumber;
		System.out.println(dNumber);
		
		// Ép kiểu tường minh -> Cần phải cast)
		double doNumber = 65432178556622259d;
		System.out.println(doNumber);
		float flNumber = (float) doNumber;
		System.out.println(flNumber);
	}

}
