package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Screen01Sales extends AbstractStepPOS {

    public Screen01Sales(WebDriver driver, TimeHelper timeHelper) {
        super(driver, timeHelper);
        this.timeHelper = timeHelper;
    }

    @Override
    public String getScreenId() {
        return "Open Sale";
    }

    @Override
    public int getScreenNumber() {
        return 1;
    }

    public void clickOnSales(){

        WebElement clickSales = driver.findElement(By.id("sales"));
        clickSales.click();
        waitForScreenReady(2000);
    }

    public void openSales() {

        WebElement clickOpenSales = driver.findElement(By.id("openSale"));
        clickOpenSales.click();
        waitForScreenReady(3000);

        WebElement enterCashAmountInHand = driver.findElement(By.xpath("//input[@placeholder='Enter Cash Amount In Hand']"));
        enterCashAmountInHand.sendKeys("123");
        waitForScreenReady(5000);

        WebElement submitButton = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/div[2]/button"));
        submitButton.click();
        waitForScreenReady(5000);
    }

    public void closeSales() {

        WebElement clickCloseSales = driver.findElement(By.id("closeSale"));
        clickCloseSales.click();
        waitForScreenReady(3000);

        WebElement enterPaidAmount = driver.findElement(By.xpath("//input[@placeholder='Enter Paid Amount']"));
        enterPaidAmount.sendKeys("123");
        waitForScreenReady(5000);

        WebElement submitButton = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/div[3]/button"));
        submitButton.click();
        waitForScreenReady(5000);
    }

    public void showTodaysSales() {

        WebElement clickTodaySales = driver.findElement(By.id("todaysSale"));
        clickTodaySales.click();
        waitForScreenReady(2000);

        WebElement clickClose = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/button[3]"));
        clickClose.click();
        waitForScreenReady(2000);
    }
}



