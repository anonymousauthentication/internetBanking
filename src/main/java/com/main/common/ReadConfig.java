package com.main.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public Properties prop;
	public FileInputStream files;

	public ReadConfig() throws IOException {
		prop = new Properties();
		files = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\main\\resources\\config.properties");
		prop.load(files);
	}

	public String getUserName() { 
		return prop.getProperty("username");
	}

	public String getBrowserName() throws IOException {
		return prop.getProperty("browser");
	}

	public String getPassword() throws IOException {
		return prop.getProperty("password");
	}

	public String getHomePageTitle() {
		return prop.getProperty("homepageTitle");
	}
	
	public String getWebUrl() {
		return prop.getProperty("weburl");
	}
}
