package com.qa.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	static void herokaupRandomTest() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com");
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.linkText("Dropdown")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		Select select = new Select(driver.findElement(By.id("dropdown")));
		
		select.selectByVisibleText("Option 2");
		
		System.out.println(select.getFirstSelectedOption().getText());
		
//		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
//				.until(ExpectedConditions.);
//		fwait.pollingEvery(Duration.ofSeconds(5));
		
		WebDriverWait iwait = new WebDriverWait(driver, Duration.ofSeconds(5),Duration.ofSeconds(1));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		
		System.out.println("");
		
		driver.quit();
	}
	
	public static void main(String[] params) {
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://parabank.parasoft.com");
			String url = driver.getCurrentUrl();
			System.out.println(url);
			
			//login page by locators
			By unameBy = By.name("username");
			By userRegPageLink = By.linkText("Register");
			
			String uname = "Ghost"; 
			
			WebElement unameElement =  driver.findElement(unameBy);
			WebElement userRegLinkElement = driver.findElement(userRegPageLink);
			
			unameElement.sendKeys(uname);
			
			String expURL = userRegLinkElement.getAttribute("href");
			
			System.out.println("Expected landing URL " + expURL);
			
			userRegLinkElement.click();
			
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			wait.until(ExpectedConditions.urlContains(expURL));
			
			wait.until((ExpectedCondition<Boolean>) webDriver ->
    			((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
			);
			
//			wait.until((ExpectedCondition<Boolean>) driver -> 
//						
//					);
			
			String actURL = driver.getCurrentUrl();
			
			System.out.println("Actual landing URL " + actURL);
			
		}
		finally {
			driver.quit();
		}
	}	
}