package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListner implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;


    @Override
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName="Test-Report-" + timeStamp + ".html";


        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

                sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Device name", "DELL");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("user", "Suyasha");
        extent.setSystemInfo("os","Windows11");
        extent.setSystemInfo("Browser name","Chrome");

    }
    @Override
    public void onTestSuccess(ITestResult result){

        test = extent.createTest(
                result.getTestClass().getName() + " :: " + result.getMethod().getMethodName()
        );
        test.log(Status.PASS,result.getName()+ " get successfully executed.");
    }

    @Override
    public void onTestFailure(ITestResult result){
        test = extent.createTest(
                result.getTestClass().getName() + " :: " + result.getMethod().getMethodName()
        );

        test.log(Status.FAIL,result.getName() + "  got failed. ");
        test.log(Status.INFO,result.getThrowable().getMessage());


            System.out.println("Test failed: " + result.getName());

            Object testClass = result.getInstance();
            WebDriver driver = ((BaseClass.Baseclass) testClass).driver;

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

            try {
                FileUtils.copyFile(src, new File(path));
                System.out.println("Screenshot saved at: " + path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void onTestSkipped(ITestResult result){
        test = extent.createTest(
                result.getTestClass().getName() + " :: " + result.getMethod().getMethodName()
        );
        test.log(Status.SKIP, result.getName()+ "got skipped");
        test.log(Status.INFO,result.getThrowable().getMessage());
    }
    @Override
    public void onFinish(ITestContext testContext){
        extent.flush(); //Writes all data to HTML report

        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" +repName;
        File extentReport = new File(pathOfExtentReport);
        try{
            Desktop.getDesktop().browse(extentReport.toURI());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}