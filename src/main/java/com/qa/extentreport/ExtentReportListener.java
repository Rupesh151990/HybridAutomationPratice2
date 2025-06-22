package com.qa.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.base.TestBase;

public class ExtentReportListener extends TestBase implements ITestListener {
	ExtentReports extentreport;
	ExtentTest extenttest;

	@Override
	public void onStart(ITestContext context) {
		extentreport = ExtentSparkReport.generateSparkReport();

	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extenttest = extentreport.createTest(testName);
		extenttest.log(Status.INFO, testName + "Start Execution");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.PASS, testName + "Test Case Got Passed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		File srcScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenShot = System.getProperty("user.dir") + "\\ScreenShot\\" + result.getName() + ".png";

		try {
			FileHandler.copy(srcScreenShot, new File(destinationScreenShot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		extenttest.addScreenCaptureFromPath(destinationScreenShot);
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL, result.getName() + "Test Case got Failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();

		File extentreportpath = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReport\\extentreport.html");
		try {
			Desktop.getDesktop().browse(extentreportpath.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
