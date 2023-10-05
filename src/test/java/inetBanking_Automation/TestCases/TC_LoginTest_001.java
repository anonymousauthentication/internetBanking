package inetBanking_Automation.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.BaseTest;
import pageObject.LoginPageObject;

public class TC_LoginTest_001 extends BaseTest {

	@Test
	public void loginTest() throws IOException {
		System.out.println("LoginTest");
		logger.info("Email Enter");
		logger.debug("aaaa");
		logger.error("fsdfsfsf212");
		getGlobalProperty();
		driver.get(prop.getProperty("weburl"));
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.setUserName(prop.getProperty("username"));
		loginPage.setPassword(prop.getProperty("password"));
		loginPage.loginSubmit();
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}
