package com.main.common;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;
	public Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setup() throws IOException {
		ReadConfig rr = new ReadConfig();
		String browser = rr.getBrowserName();
		logger = LogManager.getLogger(BaseTest.class.getName());
		logger.info("Browser Setup Phase Started...");
		if (browser.equals("chrome")) {
			logger.info("Chrome Browser Launching .. ");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			logger.info("Firefox Browser Launching .. ");
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			logger.info("Edge Browser Launching .. ");
			driver = new EdgeDriver();
		}
	}

	@AfterClass
	public void tearDown() {
		logger.info("Browser Closing");
		driver.quit();
	}
}
