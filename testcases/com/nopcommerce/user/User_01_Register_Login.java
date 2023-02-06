package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login {
	// Biến toàn cục: được sử dụng cho all hàm/ test case vì nó đc sinh ra từ Class cha
	String homePageUrl = "";
	
  @BeforeClass
  public void beforeClass() {
  }

  @Test
  public void TC_01() {
	  // Biến cục bộ: only sử dụng trong phạm vi của test case/hàm đó
	  String homePageUrl = "";
	  System.out.println(homePageUrl);
	  
	  // Block code: Khối lệnh
	  if(3<5) {
		  // Cục bô:
		  String homePageTitle = "";
		  System.out.println(homePageTitle);
	  }
  }
  
  @Test
  public void TC_02() {
  }
  
  @AfterClass
  public void afterClass() {
  }

}
