package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL="https://demo.nopcommerce.com";
	public static final String ADMIN_PAGE_URL="https://admin-demo.nopcommerce.com/admin/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	// Windows/ Mac/ Linux
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	
	/* Xử lí Authentication Alert 
	 Upload = AutoIT
	 Popup lên mới upload
	 Headless browser
	 Jenkins service (File cài đặt) - Headless
	 Jenkins (.war) - Bật browser */
	
	// Database Account/ User/ Pass/ Port of Test/dev/Staging environment
	public static final String DB_TEST_URL="32.18.252.185:9860"; //ip public
	public static final String DB_TEST_USER="automationfc";
	public static final String DB_TEST_PASS="P@ssword11!";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;
}
