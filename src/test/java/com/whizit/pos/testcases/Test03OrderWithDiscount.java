package com.whizit.pos.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;

public class Test03OrderWithDiscount extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test03OrderWithDiscount";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Order With Discount Started");

        maximizeWindow();
        themeLeafLogin();
        openPOS();
        changeToNewTab(1);
        loginPOS();
        selectTable(TABLEINITIAL,4);
        itemListDataAlertHandler();
        selectMenuItemsAndPlaceOrder();
        orderDiscount.applyDiscountAndSubmit();
        order.paymentDoneBySelectedAccount();

        ReportHelper.getTest().log(LogStatus.PASS, "Order With Discount Passed");
    }
}
