package com.qa.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	public static void main(String[] params) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com");
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.linkText("Dropdown")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		Select select = new Select(driver.findElement(By.id("dropdown")));
		
		select.selectByVisibleText("Option 2");
		
		System.out.println(select.getFirstSelectedOption().getText());
		
		driver.quit();
	}	
}