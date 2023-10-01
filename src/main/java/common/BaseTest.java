package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public FileInputStream files;

	@BeforeClass
	public void setup() {
		System.out.println("Setup ");
	    driver = new ChromeDriver();
		System.out.println("After Setup");
	}
	
//	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void getGlobalProperty() throws IOException {
		prop = new Properties();
		files = new FileInputStream(
		System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
		prop.load(files);
	}
}
