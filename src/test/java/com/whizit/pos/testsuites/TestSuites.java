package com.whizit.pos.testsuites;


import com.helper.ReportHelper;
import com.whizit.pos.testcases.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({

        //Paste all classes here
        /*Test01Sales.class,
        Test02TableOrder.class,
        Test03OrderWithDiscount.class,
        Test04OrderWithBillCommission.class,
        Test05OrderWithNCTransaction.class,
        Test06OrderWithCancelBill.class,
        Test07OrderWithSplitBill.class,*/
        Test08OrderWithLiveItem.class,
        /*Test09OrderTakeAway.class*/


})
public class TestSuites {

    @AfterClass
    public static void tearDown() {
        ReportHelper.getReports().flush();
        ReportHelper.getReports().close();
    }
}

