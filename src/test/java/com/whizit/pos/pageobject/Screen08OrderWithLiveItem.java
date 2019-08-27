package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen08OrderWithLiveItem extends AbstractStepPOS {

    public Screen08OrderWithLiveItem(WebDriver driver, TimeHelper timeHelper) {
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

    public void selectItem(int itemNumber){

        WebElement selectItem = driver.findElement(By.xpath("//*[@class='item-list-body']/child::*["+itemNumber+"]"));
        selectItem.click();
        waitForScreenReady(3000);
    }

    public void openLiveItemSection(){

        WebElement clickOnLiveItem = driver.findElement(By.xpath("//*[@id='Live Items']"));
        clickOnLiveItem.click();
        waitForScreenReady(3000);

    }

    public void deleteItem(){

        WebElement DeleteItem = driver.findElement(By.xpath("//*[text()=' Delete Item ']"));
        DeleteItem.click();
        waitForScreenReady(3000);

        WebElement clickQuantity = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[1]"));
        clickQuantity.click();
        waitForScreenReady(3000);

        WebElement selectQuantity = driver.findElement(By.className("mat-option"));
        selectQuantity.click();
        waitForScreenReady(3000);

        WebElement enterNote = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[2]"));
        enterNote.sendKeys("Test");
        waitForScreenReady(3000);

        clickSubmitButton();
    }

    public void moveItem(){

        WebElement clickMoveItem = driver.findElement(By.xpath("//*[@id='Move Item']"));
        clickMoveItem.click();
        waitForScreenReady(3000);

        WebElement enterNote = driver.findElement(By.xpath("//*[@placeholder = 'Enter Note']"));
        enterNote.sendKeys("Test");
        waitForScreenReady(3000);

        WebElement clickTable = driver.findElement(By.xpath("//*[@placeholder = 'Slect Table']"));
        clickTable.click();
        waitForScreenReady(3000);

        WebElement selectTable = driver.findElement(By.xpath("(//*[@class='mat-option ng-star-inserted'])[1]"));
        selectTable.click();
        waitForScreenReady(2000);

        clickSubmitButton();
    }

}
