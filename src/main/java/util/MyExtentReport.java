package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class MyExtentReport {
	
	public static ExtentReports getExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\reports\\TNExtentReport.html");
		ExtentSparkReporterConfig config = extentSparkReporter.config();
		config.setDocumentTitle("TNERReport");
		config.setReportName("TutorialsNinja Test Results");
		
		extentReport.attachReporter(extentSparkReporter);
		extentReport.setSystemInfo("OS",System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		extentReport.setSystemInfo("Username",System.getProperty("user.name"));
		extentReport.setSystemInfo("Selenium Version","4.25.0");
		
		return extentReport;
	
	}

}
