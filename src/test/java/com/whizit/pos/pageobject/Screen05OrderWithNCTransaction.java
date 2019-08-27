package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen05OrderWithNCTransaction extends AbstractStepPOS {

    public Screen05OrderWithNCTransaction(WebDriver driver, TimeHelper timeHelper) {
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

    public void openTransactionSection(){

        WebElement clickOnTransaction = driver.findElement(By.xpath("//*[@id=\"Transactions\"]"));
        clickOnTransaction.click();
        waitForScreenReady(3000);
    }

    public void transactionDoneByNCPay(){

        WebElement clickNCPay = driver.findElement(By.xpath("//*[@id=\"NC Pay\"]"));
        clickNCPay.click();
        waitForScreenReady(3000);

        WebElement enterNote = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])"));
        enterNote.sendKeys("testNote");
        waitForScreenReady(2000);

        clickSubmitButton();

    }

}
