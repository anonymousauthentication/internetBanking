package com.main.ExtentReportListner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chapter2 {
	public static void main(String args[]) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report2.html");
		extentReports.attachReporter(sparkReporter);

		extentReports
		.createTest("Test 1")
		.log(Status.INFO, "Info 2")
		.log(Status.INFO, "info 3")
		.log(Status.PASS,"Pass 1")
		.log(Status.INFO, "info 4")
		.log(Status.WARNING,"Warning 1")
		.log(Status.WARNING, "Warning 2")
		.log(Status.SKIP, "Skip 1");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report2.html").toURI());
	}
}
