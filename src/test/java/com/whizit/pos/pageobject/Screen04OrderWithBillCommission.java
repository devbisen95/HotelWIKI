package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen04OrderWithBillCommission extends AbstractStepPOS {

    public Screen04OrderWithBillCommission(WebDriver driver, TimeHelper timeHelper) {
        super(driver, timeHelper);
        this.timeHelper = timeHelper;
    }

    @Override
    public String getScreenId() {
        return "Order On Tables";
    }

    @Override
    public int getScreenNumber() {
        return 2;
    }

    public void openBillSection() {

        WebElement clickBill = driver.findElement(By.id("Bill"));
        clickBill.click();
        waitForScreenReady(3000);
    }

    public void printOrderBill() {

        WebElement clickPrintBill = driver.findElement(By.id("Print Bill"));
        clickPrintBill.click();
        waitForScreenReady(3000);

        javascriptExecutor.executeScript("scroll(0,250)");
        WebElement clickPrint = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/div[1]/div[3]/button"));
        clickPrint.click();
        waitForScreenReady(3000);

    }

    public void applyCommissionAndSubmit() {

        WebElement clickCommission = driver.findElement(By.id("Commission"));
        clickCommission.click();
        waitForScreenReady(3000);

        WebElement EnterAmount = driver.findElement(By.xpath("//input[@placeholder= 'Enter Amount']"));
        EnterAmount.sendKeys("10");

        WebElement enterNote = driver.findElement(By.xpath("//input[@placeholder= 'Note']"));
        enterNote.sendKeys("test note");
        waitForScreenReady(3000);

        WebElement clickPercent = driver.findElement(By.className("mat-radio-button"));
        clickPercent.click();
        waitForScreenReady(3000);

        clickSubmitButton();
    }

}
