package com.test.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.common.BaseTest;
import com.main.common.ReadConfig;
import com.main.pageObject.LoginPageObject;

public class TC_LoginTest_001 extends BaseTest {
	ReadConfig rr;

	@Test
	public void loginTest() throws IOException {
		rr = new ReadConfig();
		logger.info("Login Test Executing");
		driver.get(rr.getWebUrl());
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.setUserName(rr.getUserName());
		loginPage.setPassword(rr.getPassword());
		loginPage.loginSubmit();
	}

	@Test
	public void verifyHomeTitle() {
		if (driver.getTitle().equals(rr.getHomePageTitle())) {
			Assert.assertTrue(true);
			logger.info("Home Page Successfully Open");
		} else {
			logger.info("Login Test Fail");
			Assert.assertTrue(false);
		}
	}
}
