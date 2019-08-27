package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test06OrderWithCancelBill  extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test06OrderWithCancelBill";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Order With Cancel Bill Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        selectTable(TABLEINITIAL,5);
        itemListDataAlertHandler();
        selectMenuItemsAndPlaceOrder();
        orderNCTransaction.openTransactionSection();
        cancelBill.cancerOrderBill();

        ReportHelper.getTest().log(LogStatus.PASS, "Order With Cancel Bill Passed");
    }
}
