package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReportsClass implements ITestListener{

	ExtentSparkReporter sp;
	ExtentReports e;
	ExtentTest t;
	String repName;
	public void onStart(ITestContext context) {


		String date=new SimpleDateFormat("YY.MM.DD.HH.mm.ss").format(new Date());
		repName="Test-report-"+date+".html";
		sp=new ExtentSparkReporter(".\\repots\\"+repName);
		sp.config().setDocumentTitle("Rest-Api-Report");
		sp.config().setReportName("RestApi Reports");
		e=new ExtentReports();
		e.attachReporter(sp);
		e.setSystemInfo("Tester", "Shivarajendra");
	}
	public void onTestStart(ITestResult result) {

		t=e.createTest(result.getMethod().getMethodName());
		t.createNode(result.getName());
		t.assignCategory(result.getMethod().getGroups());

	}


	public void onTestSuccess(ITestResult result) {

		//t=e.createTest(result.getMethod().getMethodName());
//		t.createNode(result.getName());
//		t.assignCategory(result.getMethod().getGroups());
		t.log(Status.PASS,"Test Passed");

	}

	public void onTestFailure(ITestResult result) {

		//t=e.createTest(result.getMethod().getMethodName());
//				t.createNode(result.getName());
//				t.assignCategory(result.getMethod().getGroups());
				t.log(Status.FAIL,"Test Failed");

	}
	public void onTestSkipped(ITestResult result) {

		//t=e.createTest(result.getMethod().getMethodName());
//				t.createNode(result.getName());
//				t.assignCategory(result.getMethod().getGroups());
				t.log(Status.SKIP,"Test Skipped");

	}

	public void onFinish(ITestContext context) {

		e.flush();

	}

}
