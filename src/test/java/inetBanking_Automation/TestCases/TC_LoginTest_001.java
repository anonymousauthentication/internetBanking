package inetBanking_Automation.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.BaseTest;
import common.ReadConfig;
import pageObject.LoginPageObject;

public class TC_LoginTest_001 extends BaseTest {

	@Test
	public void loginTest() throws IOException {
		ReadConfig rr = new ReadConfig();
		logger.info("Login Test Executing");
		driver.get(rr.getWebUrl());
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.setUserName(rr.getUserName());
		loginPage.setPassword(rr.getPassword());
		loginPage.loginSubmit();
		if (driver.getTitle().equals(rr.getHomePageTitle())) {
			Assert.assertTrue(true);
			logger.info("Home Page Successfully Open");
		} else {
			logger.info("Login Test Fail");
			Assert.assertTrue(false);
		}
	}
}
