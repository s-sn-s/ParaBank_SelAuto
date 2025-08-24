package com.qa.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] params) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com");
		
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
	}
	
}
