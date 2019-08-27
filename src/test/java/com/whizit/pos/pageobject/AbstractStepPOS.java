package com.whizit.pos.pageobject;

import com.base.AbstractStep;
import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractStepPOS extends AbstractStep{

    public AbstractStepPOS(WebDriver driver, TimeHelper timeHelper) {
        super(driver, timeHelper);
    }

    public void clickSubmitButton(){

        try {

            WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit']"));
            submitPayment.click();
            waitForScreenReady(10000);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void waitForScreenReady(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
