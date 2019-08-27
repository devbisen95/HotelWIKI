package com.whizit.backoffice.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.whizit.backoffice.pageobject.Screen04Sales.SalesFilter.NCPAID;
import static com.whizit.backoffice.pageobject.Screen04Sales.SalesFilter.PAID;

public class Screen04Sales extends AbstractStepBackOffice {

    public Screen04Sales(WebDriver driver, TimeHelper timeHelper) {
        super(driver, timeHelper);
        this.timeHelper = timeHelper;
    }

    @Override
    public String getScreenId() {
        return "TableSection";
    }

    @Override
    public int getScreenNumber() {
        return 4;
    }

    public void openSalesSectionScreen(){

        WebElement salesSection = driver.findElement(By.xpath("(//*[@class='nav-link nav-dropdown-toggle'])[4]"));
        salesSection.click();
        waitForScreenReady(3000);
    }

    public void openCurrentSales(){

        WebElement currentSales = driver.findElement(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-dropdown[4]/app-sidebar-nav-items/app-sidebar-nav-link[1]/a"));
        currentSales.click();
        waitForScreenReady(3000);
    }

    public enum SalesFilter{
        PAID, OPEN, NCPAID, CANCELLED;
    }

    public void getCurrentSalesByBillType(String billType) {
        try {

            WebElement filterBillsDrop = driver.findElement(By.id("filterBills"));
            Select selectBills = new Select(filterBillsDrop);
            selectBills.selectByIndex(SalesFilter.valueOf(billType).ordinal());
            waitForScreenReady(9000);

        }catch (Exception e){
            e.getMessage();
        }
    }

    public void openReturnOrderItem(){

        WebElement returnOrderItem = driver.findElement(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-dropdown[4]/app-sidebar-nav-items/app-sidebar-nav-link[2]/a"));
        returnOrderItem.click();
        waitForScreenReady(3000);
    }


}
