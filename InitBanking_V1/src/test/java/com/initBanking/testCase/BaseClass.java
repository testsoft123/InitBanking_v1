package com.initBanking.testCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.initBanking.utilities.ReadConfig;



public class BaseClass {

	ReadConfig config = new ReadConfig();
	public String  baseURL= config.getApplicationURL();
	public  String  username= config.getUsername();
	public  String  password= config.getPasswordL();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browserType")
	@BeforeClass
	public void setUp(String browser){
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver = new ChromeDriver();
		}else if(browser.equals("fireFox")){
			System.setProperty("webdriver.gecko.driver", config.getFireFoxPath());
			driver= new FirefoxDriver();
		}else if(browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", config.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.get(baseURL);
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		
	}
	
}
