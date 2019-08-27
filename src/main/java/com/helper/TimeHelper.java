package com.helper;

import com.relevantcodes.extentreports.LogStatus;

public class TimeHelper {

    private long nanoTime;

    public void start() {
        nanoTime = System.nanoTime();
    }

    public void messureAndStart(String message) {
        String log = "TimeHelper " + message + " " + ((double) (System.nanoTime() - nanoTime) / 1000000000) + "s";
        System.out.println(log);
        ReportHelper.getTest().log(LogStatus.INFO, log);
        start();
    }
}
