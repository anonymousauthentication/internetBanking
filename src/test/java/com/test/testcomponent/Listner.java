package com.test.testcomponent;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.main.ExtentReportListner.ExtentReportGenerator;
import com.main.common.BaseTest;


public class Listner extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent  = ExtentReportGenerator.getReport();

	@Override
	public void onTestStart(ITestResult result) {
	test = extent.createTest(result.getMethod().getMethodName());
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("On test success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, result.getThrowable().getMessage());
		try {
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
          System.out.println("On Test Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
	  System.out.println("On Test Start New");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		try {
			Desktop.getDesktop().browse((new File("report.html").toURI()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
