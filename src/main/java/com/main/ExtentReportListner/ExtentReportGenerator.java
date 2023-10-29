package com.main.ExtentReportListner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
	public static ExtentReports getReport() {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
		sparkReporter.config().setReportName("Internet Banking Report");
		sparkReporter.config().setDocumentTitle("Internet Banking Document");
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Manohar Kant Joshi", "SDET");
		return extentReports;
	}
}