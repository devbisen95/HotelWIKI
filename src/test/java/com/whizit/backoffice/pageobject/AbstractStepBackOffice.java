package com.whizit.backoffice.pageobject;

import com.base.AbstractStep;
import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractStepBackOffice extends AbstractStep{

    public AbstractStepBackOffice(WebDriver driver, TimeHelper timeHelper) {
        super(driver, timeHelper);
    }

    public void submitButton(){

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submitButton.click();
        waitForScreenReady(4000);
    }

    public void searchButton(){

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"search\"]"));
        submitButton.click();
        waitForScreenReady(4000);
    }


    public void waitForScreenReady(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
