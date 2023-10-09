package com.main.ExtentReportListner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chapter1 {
	public static void main(String args[]) throws IOException {
       ExtentReports extentReports = new ExtentReports();
       ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html"); 
       extentReports.attachReporter(sparkReporter);
       extentReports.flush();
       Desktop.getDesktop().browse(new File("report.html").toURI());
	}
}
