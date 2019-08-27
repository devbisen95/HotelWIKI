package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test09OrderTakeAway extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test09OrderTakeAway";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Order With Take Away Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        takeAway.selectTakeOrder();
        itemListDataAlertHandler();
        selectMenuItemsAndPlaceOrder();
        orderCommission.openBillSection();
        orderCommission.printOrderBill();
        order.paymentDoneBySelectedAccount();

        ReportHelper.getTest().log(LogStatus.PASS, "Order With Take Away Started");
    }
}
