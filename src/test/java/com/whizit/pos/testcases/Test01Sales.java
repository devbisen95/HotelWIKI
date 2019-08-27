package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;


public class Test01Sales extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test01Sales";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Sales Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        sales.clickOnSales();
        sales.showTodaysSales();
        sales.clickOnSales();
        try {
            sales.openSales();
        }catch (Exception e){
            sales.closeSales();
        }

        ReportHelper.getTest().log(LogStatus.PASS, "Sales Passed");
    }
}
