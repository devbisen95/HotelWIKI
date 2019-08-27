package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen06OrderWithCancelBill  extends AbstractStepPOS {

    public Screen06OrderWithCancelBill(WebDriver driver, TimeHelper timeHelper) {
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

    public void cancerOrderBill(){

        WebElement cancelBill = driver.findElement(By.xpath("//*[@id=\"Cancel Bill\"]"));
        cancelBill.click();
        waitForScreenReady(3000);

        WebElement enterNote = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])"));
        enterNote.sendKeys("Test");
        waitForScreenReady(3000);

        clickSubmitButton();

    }

}
