package com.vishall.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//"final" class cannot be extended
public final class ExtentManager {

    private static ExtentReports extent;

    //constructor must be private for a final class
    //so that this class cannot be instantiated
    private ExtentManager(){}

    //getInstance method will be called by Listener onTestStart
    public static ExtentReports getInstance(){
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Test Execution Report");
            extent.attachReporter(spark);
        }
        return extent;
    }

}
