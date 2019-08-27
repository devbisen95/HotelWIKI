package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test07OrderWithSplitBill  extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test07OrderWithSplitBill";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Order With Split Bill Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        selectTable(TABLEINITIAL,6);
        itemListDataAlertHandler();
        selectMenuItemsAndPlaceOrder();
        orderCommission.openBillSection();
        orderSplitBill.splitOrderBill();
        order.paymentDoneBySelectedAccount();

        ReportHelper.getTest().log(LogStatus.PASS, "Order With Split Bill Passed");
    }
}
