package com.whizit.reusable;


import com.base.CoreBase;
import com.whizit.backoffice.pageobject.Screen01Account;
import com.whizit.backoffice.pageobject.Screen02MenuItems;
import com.whizit.backoffice.pageobject.Screen03TableSection;
import com.whizit.backoffice.pageobject.Screen04Sales;
import com.whizit.pos.pageobject.*;

public abstract class BaseTest extends CoreBase {

    //Declare object for BackOffice Screens
    protected Screen01Account account;
    protected Screen02MenuItems menuItems;
    protected Screen03TableSection tableSection;
    protected Screen04Sales salesBO;






    //Declare object for POS Screens
    protected Screen01Sales sales;
    protected Screen02TableOrder order;
    protected Screen03OrderWithDiscount orderDiscount;
    protected Screen04OrderWithBillCommission orderCommission;
    protected Screen05OrderWithNCTransaction orderNCTransaction;
    protected Screen06OrderWithCancelBill cancelBill;
    protected Screen07OrderWithSplitBill orderSplitBill;
    protected Screen08OrderWithLiveItem liveItem;
    protected Screen09OrderTakeAway takeAway;


    @Override
    public void customInitialize() {

        //Create object for BackOffice Screens
        account = new Screen01Account(driver, timeHelper);
        menuItems = new Screen02MenuItems(driver, timeHelper);
        tableSection = new Screen03TableSection(driver,timeHelper);
        salesBO = new Screen04Sales(driver,timeHelper);





        //Create object for POS Screens
        sales = new Screen01Sales(driver, timeHelper);
        order = new Screen02TableOrder(driver,timeHelper);
        orderDiscount = new Screen03OrderWithDiscount(driver,timeHelper);
        orderCommission = new Screen04OrderWithBillCommission(driver,timeHelper);
        orderNCTransaction = new Screen05OrderWithNCTransaction(driver,timeHelper);
        cancelBill = new Screen06OrderWithCancelBill(driver,timeHelper);
        orderSplitBill = new Screen07OrderWithSplitBill(driver,timeHelper);
        liveItem = new Screen08OrderWithLiveItem(driver,timeHelper);
        takeAway = new Screen09OrderTakeAway(driver,timeHelper);

    }

    public String getWiKIBasePath() {
        return "http://192.168.100.10:8081/hotelwiki/";
    }
}
