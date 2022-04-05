package com.sfdc.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src = new File("./Configuration\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String userName = prop.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String passWord = prop.getProperty("password");
		return passWord;
	}
	
	public String getChromePath() {
		String chromePath = prop.getProperty("chromepath");
		return chromePath;
	}
	
	public String getFirefoxPath() {
		String ffPath = prop.getProperty("firefoxpath");
		return ffPath;
	}
	
	public String getWUserName() {
		String wruserName = prop.getProperty("wrUName");
		return wruserName;
	}
	
	public String getWPassword() {
		String wrpassWord = prop.getProperty("wePWrd");
		return wrpassWord;
	}
	
	public String getLastname() {
		String lastname = prop.getProperty("lastNameAbout");
		return lastname;
	}
	
	public String getText() {
		String txt = prop.getProperty("testforpost");
		return txt;
	}

}
