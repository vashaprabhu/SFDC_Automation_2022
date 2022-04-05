package com.sfdc.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sfdc.testCases.BaseClass;

public class ReportListener implements ITestListener{
	public ExtentReports extent;
	public ExtentHtmlReporter htmlReport;
	public ExtentTest test;
	
	BaseClass base = new BaseClass();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		try {
			test.fail("screenshot is "+test.addScreenCaptureFromPath(base.takeScreenshot(base.driver)));
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		String uniqueDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\"+uniqueDate+"_listenerReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);	
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
}
