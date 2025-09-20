package com.qa.parabank.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.parabank.pages.HomePage;
import com.qa.parabank.pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	
	protected LoginPage loginPage;
	protected HomePage homePage;
	
	@BeforeMethod
	public void setup(){
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://parabank.parasoft.com");
		
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
