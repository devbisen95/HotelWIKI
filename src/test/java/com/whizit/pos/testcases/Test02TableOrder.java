package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test02TableOrder extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test02TableOrder";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Order On Tables Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        selectTable(TABLEINITIAL,4);
        itemListDataAlertHandler();
        selectMenuItemsAndPlaceOrder();
        order.paymentDoneBySelectedAccount();

        ReportHelper.getTest().log(LogStatus.PASS, "Order On Tables Passed");
    }
}
