package com.whizit.backoffice.testcases;

import com.helper.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.whizit.reusable.ReusableSteps;


public class Test01Account extends ReusableSteps {

    @Override
    public String getTestName() {
        return "Test01Account";
    }

    @Override
    public String getBasePath() {
        return getWiKIBasePath();
    }

    @Override
    public void executeTest() {

        ReportHelper.getTest().log(LogStatus.UNKNOWN, "Account Started");

        maximizeWindow();
        themeLeafLogin();
        openBO();
        changeToNewTab(1);
        loginBackOffice();
        account.openAccountSectionScreen();
        account.openFinancialAccount();
        account.addFinancialAccount();
        account.searchFinancialAccount();
        account.openBankAccount();
        account.addBankAccount();
        account.searchBankAccount();
        account.openTransaction();
        account.addTransaction();
        account.openTenderAccount();
        account.createTender();
        account.openBillSettlement();
        account.settleBill();
        account.openBillDesign();
        account.addBillDesign();

        ReportHelper.getTest().log(LogStatus.PASS, "Account Passed");
    }
}
