package com.initBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver localDriver;
	public LoginPage(WebDriver remoteDriver){
		localDriver=remoteDriver;
		PageFactory.initElements(remoteDriver, this);
		}
	@FindBy(name="uid")
	WebElement txtUserId;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnSubmit;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;
	
	//action method
	public void setUserName(String uname){
		txtUserId.sendKeys(uname);
	}
	public void setPassword(String pwd){
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit(){
		btnSubmit.click();
	}
	public void clickLogOutt(){
		logout.click();
	}
}
