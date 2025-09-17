package com.qa.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).until(null);
		fwait.pollingEvery(Duration.ofSeconds(5));
		
		WebDriverWait iwait = new WebDriverWait(driver, Duration.ofSeconds(5),Duration.ofSeconds(1));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		
		System.out.println("");
		
		driver.quit();
	}	
}