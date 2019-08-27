package com.helper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import java.io.File;
import java.util.Objects;

public class ReportHelper {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static long startNanoTime;


    public static ExtentReports getReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports("." + File.separator + "ExtentReportTest.html", true, NetworkMode.OFFLINE);
        }
        return extent;
    }

    public static ExtentTest getTest() {
        if (Objects.isNull(test)) {
            startTest("test started in background");
        }
        return test;
    }

    public static void startTest(String name) {
        test = getReports().startTest(name);
        startNanoTime = System.nanoTime();
    }

    public static void startTest(String name, String description) {

        test = getReports().startTest(name, description);
    }

    public static void endTest() {
        getTest().log(LogStatus.PASS, "test ended after " + ((double) (System.nanoTime() - startNanoTime) / 1000000000) + "s");
        getReports().endTest(test);
        getReports().flush();
    }


}
