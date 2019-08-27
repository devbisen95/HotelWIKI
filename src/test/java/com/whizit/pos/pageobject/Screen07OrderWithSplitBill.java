package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen07OrderWithSplitBill extends AbstractStepPOS {

    public Screen07OrderWithSplitBill(WebDriver driver, TimeHelper timeHelper) {
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

    public void splitOrderBill(){

        WebElement splitBill = driver.findElement(By.xpath("//*[@id ='Split Bill']"));
        splitBill.click();
        waitForScreenReady(3000);

        WebElement selectQuantity = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[1]"));
        selectQuantity.click();

        waitForScreenReady(3000);
        WebElement clickOnQty = driver.findElement(By.xpath("(//*[@class ='mat-option ng-star-inserted'])[1]"));
        clickOnQty.click();
        waitForScreenReady(3000);

        WebElement selectQuantity2 = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[2]"));
        selectQuantity2.click();
        waitForScreenReady(3000);

        WebElement clickOnQty2 = driver.findElement(By.xpath("(//*[@class ='mat-option ng-star-inserted'])[1]"));
        clickOnQty2.click();
        waitForScreenReady(3000);

        clickSubmitButton();
    }
}

