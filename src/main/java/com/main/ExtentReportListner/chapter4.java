package com.main.ExtentReportListner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chapter4 {
	static WebDriver driver;
	public static void main(String args[]) throws Exception {
	 driver = new ChromeDriver();
	 driver.get("https://www.google.com/");
      ExtentReports extentReports = new ExtentReports();
      File file = new File("report4.html");
      ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
      extentReports.attachReporter(sparkReporter);
      
    
      String base64 = getScreenshotBase64(driver);
      String filePath = getScreenshot("google", driver);
      
      Throwable t = new Throwable("This is Exception");
      extentReports.createTest("Screenshot Test 1","This is for attachhing the screenshot fror test in test level")
      .info("This is info message")
      .addScreenCaptureFromBase64String(base64);
      
      extentReports.createTest("Screenshot Test 1","This is for attachhing the screenshot fror test in test level")
      .info("This is info message")
      .addScreenCaptureFromBase64String(base64 , "Google Home Page");
      
      extentReports.createTest("Screenshot Test 1","This is for attachhing the screenshot fror test in test level")
      .info("This is info message")
      .addScreenCaptureFromPath(filePath);
      
      extentReports.createTest("Screenshot Test 1","This is for attachhing the screenshot fror test in test level")
      .info("This is info message")
      .addScreenCaptureFromPath(filePath, "Google Home Page");
      
      extentReports.createTest("Screenshot Test 1","This is for attachhing the screenshot fror test in log level Base64")
      .info("This is info message")
      .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build())
      .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"Google Home Page").build())
      .fail("Log Text Message",MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"Google Home Page").build())
      .fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"Google Home Page").build());

      
      extentReports.createTest("Screenshot Test 1","This is for attachhing the screenshot fror test in log level using path")
      .info("This is info message")
      .fail(MediaEntityBuilder.createScreenCaptureFromPath(filePath).build())
      .fail(MediaEntityBuilder.createScreenCaptureFromPath(filePath,"Google Home Page").build())
      .fail("Log Text Message",MediaEntityBuilder.createScreenCaptureFromPath(filePath,"Google Home Page").build())
      .fail(t,MediaEntityBuilder.createScreenCaptureFromPath(filePath,"Google Home Page").build());  
      
      
      extentReports.flush();
      driver.close();
      Desktop.getDesktop().browse((new File("report4.html").toURI()));
	}
	public static  String getScreenshot(String testClassNmae, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File File = new File(System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png");
		FileUtils.copyFile(source, File);
		return System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png";
	}
	
	public static String getScreenshotBase64( WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		String source = ss.getScreenshotAs(OutputType.BASE64);
		return source;
	}
}
