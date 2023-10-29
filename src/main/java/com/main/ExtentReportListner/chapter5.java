package com.main.ExtentReportListner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class chapter5 {
	public static void main(String args[]) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report5.html");
		extentReports.attachReporter(sparkReporter); 
		sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] {ViewName.TEST,
				ViewName.DASHBOARD}).apply();
		
		extentReports.createTest("Test 1")
		.assignAuthor("Manohar")
		.assignCategory("Smoke")
		.assignDevice("Chrome 101")
		.pass("Pass Test");
				
		extentReports.createTest("Test 2 ")
		.assignAuthor("John Doe")
		.assignCategory("Sanity")
		.assignDevice("Edge 50")
		.fail("fail Test");
		
		extentReports.createTest("Test 2 ")
		.assignAuthor("Peter rack")
		.assignCategory("Regression")
		.assignDevice("Firefox 102")
		.fail("fail Test");

		extentReports.createTest("Test 2 ")
		.assignAuthor("Peter rack")
		.assignAuthor("Manohar")
		.assignCategory("Regression")
		.assignCategory("Smoke")
		.assignDevice("Firefox 102")
		.assignDevice("Edge 102")
		.skip("fail Test");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report5.html").toURI());
	}
}
