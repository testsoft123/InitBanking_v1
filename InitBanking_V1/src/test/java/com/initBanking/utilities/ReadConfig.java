package com.initBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	public ReadConfig(){
		
		File file = new File("./Configration/config.properties");
		try {
			
			FileInputStream fileInputStream = new FileInputStream(file);
			properties= new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String getApplicationURL(){
		String url = properties.getProperty("baseURL");
		return url;
	}
	public String getUsername(){
		String uname = properties.getProperty("userName");
		return uname;
	}
	public String getPasswordL(){
		String pass = properties.getProperty("password");
		return pass;
	}
	public String getChromePath(){
		String chroPath = properties.getProperty("chromePath");
		return chroPath;
	}
	public String getFireFoxPath(){
		String firePath = properties.getProperty("fireFoxpath");
		return firePath;
	}
	public String getIEPath(){
		String iePath = properties.getProperty("iePath");
		return iePath;
	}
	

}
