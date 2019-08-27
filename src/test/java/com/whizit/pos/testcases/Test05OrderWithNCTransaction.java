package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test05OrderWithNCTransaction extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test05OrderWithNCTransaction";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Order With NC Transaction Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        selectTable(TABLEINITIAL,5);
        itemListDataAlertHandler();
        selectMenuItemsAndPlaceOrder();
        orderNCTransaction.openTransactionSection();
        orderNCTransaction.transactionDoneByNCPay();

        ReportHelper.getTest().log(LogStatus.PASS, "Order With NC Transaction Passed");
    }
}
