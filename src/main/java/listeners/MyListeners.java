package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.MyExtentReport;
import util.Utilities;

public class MyListeners implements ITestListener {
	
	ExtentReports report;
	ExtentTest extentTest;
	

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = report.createTest(result.getName());
		extentTest.log(Status.INFO,result.getName()+" test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS,result.getName()+" test got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.log(Status.FAIL,result.getName()+" test got failed");
		
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		String screenshotFilePath = Utilities.takeScreenshot(driver,result.getName());

		extentTest.addScreenCaptureFromPath(screenshotFilePath);
		extentTest.log(Status.INFO,result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP,result.getName()+" test got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		report = MyExtentReport.getExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		String extentReportPath = System.getProperty("user.dir")+"\\target\\reports\\TNExtentReport.html";
		File extentReportFile = new File(extentReportPath);
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	

}
