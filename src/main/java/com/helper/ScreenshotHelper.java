package com.helper;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotHelper {

    private WebDriver driver;
    private static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd-HHmmss-SSS");

    public ScreenshotHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String saveScreenshot(String message) {
        String path = "screenshots/" + DATE_FORMAT.format(new Date()) + "-" + message + ".png";
        saveScreenshotFile(path);
        System.out.println("Screenshot created: /ws/" + path);
        ReportHelper.getTest().log(LogStatus.INFO, message + ReportHelper.getTest().addScreenCapture(path));
        return path;
    }

    private void saveScreenshotFile(String screenshotFileName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotFileName));
        } catch (IOException e) {
            Assert.fail("unable to create screenshot");
        }
    }
}
