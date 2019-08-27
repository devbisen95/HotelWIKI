package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test08OrderWithLiveItem extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test08OrderWithLiveItem";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Order With Live Item Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        //Entered tableNumber should be as joined
        selectTable(TABLEINITIAL,3);
        itemListDataAlertHandler();
        liveItem.selectItem(1);
        liveItem.openLiveItemSection();
        liveItem.deleteItem();
        liveItem.selectItem(2);
        liveItem.moveItem();

        ReportHelper.getTest().log(LogStatus.PASS, "Order With Live Item Started");

    }
}
