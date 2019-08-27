package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen09OrderTakeAway extends AbstractStepPOS {

    public Screen09OrderTakeAway(WebDriver driver, TimeHelper timeHelper) {
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

    public void selectTakeOrder(){

        WebElement takeaway = driver.findElement(By.xpath("//*[@class='btn active-background']"));
        takeaway.click();
        waitForScreenReady(3000);
    }

}
