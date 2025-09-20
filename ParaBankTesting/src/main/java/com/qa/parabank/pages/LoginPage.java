package com.qa.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By userNameBy = By.name("username");
	private By passwordBy = By.name("password");
	private By loginButtonBy = By.xpath("//input[@value='Log In']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUserName(String userName) {
		driver.findElement(userNameBy).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordBy).sendKeys(password);
	}
	
	public HomePage clickLoginButton() {
		driver.findElement(loginButtonBy).click();
		return new HomePage(driver);
	}
	
	public String getLoginButtoneLandingURL() {
		return driver.getCurrentUrl();
	}
	
	public void loginWith(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickLoginButton();
	}
}