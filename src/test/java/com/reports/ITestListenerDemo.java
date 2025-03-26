package com.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerDemo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Tests are started");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Tests are finished");
	}

	

}
