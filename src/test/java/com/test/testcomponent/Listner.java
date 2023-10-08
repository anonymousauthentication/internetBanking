package com.test.testcomponent;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listner extends TestListenerAdapter {

	public void onTestStart(ITestResult tr) {
		System.out.println("Test Started");

	}

	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test Pass");
	}

	public void onTestFailure(ITestResult tr) {
		System.out.println("Test Fail");
	}

	public void onFinish(ITestResult tr) {
		System.out.println("Test Finish");
	}
}
