package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test04OrderWithBillCommission extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test04OrderWithBillCommission";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Order With BillCommission Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        selectTable(TABLEINITIAL,5);
        itemListDataAlertHandler();
        selectMenuItemsAndPlaceOrder();
        orderCommission.openBillSection();
        orderCommission.printOrderBill();
        orderCommission.applyCommissionAndSubmit();
        order.paymentDoneBySelectedAccount();

        ReportHelper.getTest().log(LogStatus.PASS, "Order With BillCommission Passed");
    }
}
