package com.whizit.backoffice.testsuites;


import com.base.CoreBase;
import com.helper.ReportHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.base.CoreBase.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({

        //Paste all .classses here

})
public class TestSuites {

    @AfterClass
    public static void tearDown() {
        ReportHelper.getReports().flush();
        ReportHelper.getReports().close();
    }
}

