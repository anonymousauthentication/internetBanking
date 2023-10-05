package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public FileInputStream files;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		System.out.println(br);
		logger = LogManager.getLogger(BaseTest.class.getName());
		//PropertyConfigurator.configure("//logs//log4j2.xml");
		logger.info("aaa");
		logger.debug("dsada");
		logger.error("fsdfsfsf");
		System.out.println("Setup ");
		driver = new ChromeDriver();
		System.out.println("After Setup");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void getGlobalProperty() throws IOException {
		prop = new Properties();
		files = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		prop.load(files);
	}
}
