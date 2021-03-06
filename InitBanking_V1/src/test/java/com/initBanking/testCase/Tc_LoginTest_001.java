package com.initBanking.testCase;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.initBanking.pageObject.LoginPage;

public class Tc_LoginTest_001  extends BaseClass{

	@Test
	public void loginTest() throws IOException{
		
		
		logger.info("URL is opned");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("Username is Entered");
		loginPage.setPassword(password);
		
		loginPage.clickSubmit();
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 1Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
		
}
