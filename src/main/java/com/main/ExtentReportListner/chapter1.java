package com.main.ExtentReportListner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chapter1 {
	public static void main(String args[]) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
		extentReports.attachReporter(sparkReporter);
		ExtentTest test1 = extentReports.createTest("Test 1");
		test1.pass("Test is pass");

		ExtentTest test2 = extentReports.createTest("Test 1");
		test2.log(Status.PASS, "Test is pass");

		extentReports.createTest("Test 1").skip("This is Skipped");
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
}
