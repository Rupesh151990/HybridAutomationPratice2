package com.qa.extentreport;


import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.base.TestBase;

public class ExtentSparkReport extends TestBase {

	public static ExtentReports generateSparkReport() {
		
		ExtentReports extentReports = new ExtentReports();
		File extentReportPath = new File(System.getProperty("user.dir")+"//test-output//ExtentReport//extentreport.html");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(extentReportPath);
		
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Free Application URL");
		sparkReport.config().setTimeStampFormat("dd/mm/yyy hh:mm:ss");
		
		extentReports.attachReporter(sparkReport);
		
		extentReports.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReports.setSystemInfo("Browser ", prop.getProperty("browser"));
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		
		return extentReports;
		
		
		

	}

}
