package javaBasic;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Topic_13_SubString {
	public static void main(String[] args) {
	String firsttext = "id=Email";
	String secondtext = "css=input[@id='Password']";
	String thirdtext = "xpath=//button[text()='Log in']";
	System.out.println(firsttext.substring(3));
	System.out.println(secondtext.substring(4));
	System.out.println(thirdtext.substring(6));
	}
}