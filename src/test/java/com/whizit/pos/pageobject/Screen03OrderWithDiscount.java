package com.whizit.pos.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen03OrderWithDiscount extends AbstractStepPOS {

    public Screen03OrderWithDiscount(WebDriver driver, TimeHelper timeHelper) {
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

    public void applyDiscountAndSubmit() {

        WebElement clickOffers = driver.findElement(By.id("Offers"));
        clickOffers.click();
        waitForScreenReady(3000);

        WebElement clickDiscount = driver.findElement(By.id("Disount"));
        clickDiscount.click();
        waitForScreenReady(3000);

        WebElement enterDiscount = driver.findElement(By.xpath("//input[@placeholder='Discount']"));
        enterDiscount.sendKeys("10");
        waitForScreenReady(3000);

        WebElement enterNote = driver.findElement(By.xpath("//input[@placeholder='Note']"));
        enterNote.sendKeys("Today's Discount");
        waitForScreenReady(3000);

        WebElement enterProvider = driver.findElement(By.xpath("//input[@placeholder='Provider']"));
        enterProvider.sendKeys("Cashier");
        waitForScreenReady(3000);

        WebElement clickCategoryName = driver.findElement(By.xpath("//input[@placeholder='categoryName']"));
        clickCategoryName.click();
        waitForScreenReady(3000);

        WebElement clickOnFlat = driver.findElement(By.cssSelector("#mat-option-0"));
        clickOnFlat.click();
        waitForScreenReady(3000);

        WebElement clickOnPercent = driver.findElement(By.className("mat-radio-button"));
        clickOnPercent.click();
        waitForScreenReady(3000);

       clickSubmitButton();
    }
}
