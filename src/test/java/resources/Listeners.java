package resources;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	

	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/ExtentReportsResult.html");
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("API Testing Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name", "HubWallet Terminal App");
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "HubWallet");
	}
	 
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed is :- "+result.getName());
		test.log(Status.PASS, "Test Case Passed is :- "+result.getInstanceName());
	}
	
		public void onTestFailure(ITestResult result) {
			test = extent.createTest(result.getName());
			test.log(Status.FAIL, "Test Case Failed is :- "+result.getName());
			test.log(Status.FAIL, "Test Case Failed is :- "+result.getThrowable());
		}
		
		public void onTestSkipped(ITestResult result) {
			test = extent.createTest(result.getName());
			test.log(Status.SKIP, "Test Case Skipped is :- "+result.getName());
	
		}
		
		public void onFinish(ITestContext testContext) {
			extent.flush();
		}

}





















