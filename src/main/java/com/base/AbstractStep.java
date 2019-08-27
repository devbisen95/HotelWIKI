package com.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helper.ScreenshotHelper;
import com.helper.TimeHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractStep {

    protected WebDriver driver;
    protected JavascriptExecutor javascriptExecutor;
    protected WebDriverWait wait;
    protected ScreenshotHelper screenshotHelper;
    protected TimeHelper timeHelper;

    public AbstractStep(WebDriver driver, TimeHelper timeHelper) {
        this.driver = driver;
        this.timeHelper = timeHelper;
        wait = new WebDriverWait(driver, 50);
        this.javascriptExecutor = (JavascriptExecutor) driver;
        screenshotHelper = new ScreenshotHelper(driver);
    }

    public abstract String getScreenId();

    public abstract int getScreenNumber();

}
