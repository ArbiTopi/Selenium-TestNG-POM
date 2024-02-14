package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.BaseInformation;
import utilities.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends BaseInformation implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    @Override
    public void onFinish(ITestContext Result)
    {
        extent.flush();

    }

    @Override
    public void onStart(ITestContext Result)
    {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result)
    {
        test.fail(Result.getThrowable());
        String filepath = null;
        try {
            filepath = getScreenShot(Result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filepath,Result.getMethod().getMethodName());


        System.out.println("The name of the testcase failed is :"+Result.getName());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result)
    {
        test.log(Status.SKIP,"Test skipped");
        System.out.println("The name of the testcase Skipped is :"+Result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result)
    {
        test =extent.createTest(Result.getMethod().getMethodName());

        System.out.println(Result.getName()+" test case started");
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result)
    {
        test.log(Status.PASS,"Test passed sucesfully");
        System.out.println("The name of the testcase passed is :"+Result.getName());
    }
}
