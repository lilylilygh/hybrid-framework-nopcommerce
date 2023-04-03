package pageUIs.nopCommerce.user;

public class HomePageUI {
	// static: cho phép truy cập trực tiếp từ tên class, có thể chia sẻ dữ liệu giữa nhiều luồng khác nhau
	// biến constant: 1 giá trị k đc phép thay đổi (static final)
	// Convention: VIẾT HOA, phân cách bởi_
	public static final String REGISTER_LINK ="css=a[class='ico-register']";
	public static final String LOGIN_LINK ="xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK ="xpath=//a[@class='ico-account']";
}
