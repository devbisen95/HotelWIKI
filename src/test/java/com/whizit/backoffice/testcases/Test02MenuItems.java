package com.whizit.backoffice.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test02MenuItems extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test02MenuItems";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Menu Items Started");

        maximizeWindow();
        themeLeafLogin();
        openBO();
        changeToNewTab(1);
        loginBackOffice();
        menuItems.openMenuItemsSectionScreen();
        menuItems.openMenuItems();
        // Provide exportFilePath to export Menu Items in excel file
        menuItems.importExportMenuItem("");
        menuItems.addMenuItems();
        menuItems.searchMenuItems();
        menuItems.openRecipes();
        menuItems.addRecipes();
        menuItems.searchRecipes();
        menuItems.openCategory();
        menuItems.addCategory();

        ReportHelper.getTest().log(LogStatus.PASS, "Menu Items Passed");

    }
}
