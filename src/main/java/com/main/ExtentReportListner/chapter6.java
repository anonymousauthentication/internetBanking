package com.main.ExtentReportListner;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class chapter6 {
	public static void main(String args[]) throws Exception {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter  sparkReporters = new ExtentSparkReporter("reports6.html");
        sparkReporters.config().setTheme(Theme.DARK);
        sparkReporters.config().setReportName("Report Name");
        sparkReporters.config().setDocumentTitle("Document Title");
        sparkReporters.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
        sparkReporters.config().setCss(".badge-primary {background-color: #fff000;}");
        sparkReporters.config().setCss(".nav-logo{dispay:none;}");
        extentReports.attachReporter(sparkReporters);
        
        extentReports.createTest("Test1")
        .pass("Test 1 is pass")
        .log(Status.PASS, "Test 1 log");
        
        extentReports.flush();
        Desktop.getDesktop().browse(new File("reports6.html").toURI());
       
	}
}
