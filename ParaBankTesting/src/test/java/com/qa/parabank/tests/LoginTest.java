package com.qa.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.parabank.base.BaseTest;

public class LoginTest extends BaseTest{

	private String HOMEPAGEURL = "https://parabank.parasoft.com/parabank/overview.htm";
	
	@Test(groups= {"regression","sanity"})
	public void testValidLogin() {
		
		loginPage.enterUserName("savinUser");
		loginPage.enterPassword("jysZaq-siccy3-huccoh");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		homePage = loginPage.clickLoginButton();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(homePage.getHomePageURL(),HOMEPAGEURL);
		
	}
	
	@Test(groups= {"regression","sanity"})
	public void testInvalidLogin() {
		
		loginPage.enterUserName("savin");
		loginPage.enterPassword("jysZaq-siccy3-huccoh");
		homePage = loginPage.clickLoginButton();
		
		Assert.assertEquals(homePage.getHomePageURL(),HOMEPAGEURL);
		
	}
}