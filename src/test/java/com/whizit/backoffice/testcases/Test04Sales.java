package com.whizit.backoffice.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test04Sales extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test04Sales";
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
        openBO();
        changeToNewTab(1);
        loginBackOffice();
        salesBO.openSalesSectionScreen();
        salesBO.openCurrentSales();
        salesBO.getCurrentSalesByBillType("OPEN");



        ReportHelper.getTest().log(LogStatus.PASS, "Sales Passed");

    }
}
