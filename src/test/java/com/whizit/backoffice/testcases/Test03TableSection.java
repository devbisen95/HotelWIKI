package com.whizit.backoffice.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test03TableSection extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test03TableSection";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Table Section Started");

        maximizeWindow();
        themeLeafLogin();
        openBO();
        changeToNewTab(1);
        loginBackOffice();
        tableSection.openTableSectionScreen();
        tableSection.openSection();
        tableSection.addTableSection();
        tableSection.searchTableSection();
        tableSection.openCategory();
        tableSection.addTableCategory();
        tableSection.openTables();
        tableSection.addTables();
        tableSection.searchTables();

        ReportHelper.getTest().log(LogStatus.PASS, "Table Section Passed");

    }
}
