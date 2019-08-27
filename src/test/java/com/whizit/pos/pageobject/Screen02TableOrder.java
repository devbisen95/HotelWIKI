package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen02TableOrder extends AbstractStepPOS {

    public Screen02TableOrder(WebDriver driver, TimeHelper timeHelper) {
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

    public void paymentDoneBySelectedAccount() {

        WebElement clickPayment = driver.findElement(By.xpath("//*[@id='paymentBtn']"));
        clickPayment.click();
        waitForScreenReady(3000);

        WebElement clickAccount = driver.findElement(By.xpath("//*[@id=\"account\"]/div/div[1]/span"));
        clickAccount.click();
        waitForScreenReady(5000);

        WebElement selectAccount = driver.findElement(By.xpath("(//*[@class='mat-option-text'])[1]"));
        selectAccount.click();

        clickSubmitButton();

    }

}
