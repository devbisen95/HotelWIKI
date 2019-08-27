package com.base;

import com.driver.*;
import com.helper.Browser;
import com.helper.ReportHelper;
import com.helper.ScreenshotHelper;
import com.helper.TimeHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;


import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public abstract class CoreBase {

    private static final String PARAM_BROWSER = "browser";

    private static final String PARAM_HUBURL = "huburl";

    private static final String HUB_LOCALHOST_URL = "http://127.0.0.1:4444/wd/hub";

    protected WebDriver driver;

    protected TimeHelper timeHelper;

    public ScreenshotHelper screenshotHelper;

    private Browser browser;

    public abstract String getTestName();

    public abstract void executeTest();

    public abstract String getBasePath();

    public Proxy getProxy() {
        return null;
    }

    public CoreBase() {
    }

    @Test
    public void test() throws IOException, InterruptedException {

        ReportHelper.startTest(this.getTestName());
        ReportHelper.getTest().log(LogStatus.INFO, "URL " + this.getBaseUrl());

        try {

            this.executeTest();

        } catch (Throwable e) {

            screenshotHelper.saveScreenshot("failed");

            StringBuffer reportLine = new StringBuffer();
            reportLine.append(e.getMessage() + "<br >");
            Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> reportLine.append("&nbsp;&nbsp;" + stackTraceElement.toString() + "<br />"));
            ReportHelper.getTest().log(LogStatus.FAIL, reportLine.toString());

            StringBuffer failLine = new StringBuffer();
            failLine.append(e.getMessage() + "\r\n");
            Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> failLine.append("  " + stackTraceElement.toString() + "\r\n"));
            fail(failLine.toString());

        } finally {

            ReportHelper.endTest();
        }
    }


    @Before
    public void initialize() throws Exception {
        System.out.println("@Before start");
        IDriver iDriver = this.getDriver();

        try {
            URL url = null;
            String urlParam = System.getProperty(PARAM_HUBURL);
            if (StringUtils.isNotBlank(urlParam)) {
                url = new URL(urlParam);
            } else {
                url = new URL(HUB_LOCALHOST_URL);
            }
            System.out.println("url = " + url);
            String baseUrL = getBaseUrl();
            System.out.println("baseUrL = " + baseUrL);
            driver = iDriver.launchDriver(url, baseUrL, Platform.ANY, getProxy());
            System.out.println("driver = " + driver);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        screenshotHelper = new ScreenshotHelper(driver);
        timeHelper = new TimeHelper();
        customInitialize();
        System.out.println("@Before done");
    }

    public void customInitialize() {
    }

    protected String getBaseUrl() {

        return getBasePath();
    }

    private IDriver getDriver() {
        String browserParam = System.getProperty(PARAM_BROWSER);
        if (StringUtils.isNotBlank(browserParam)) {
            browser = Browser.valueOf(browserParam.toUpperCase());
        }

        IDriver iDriver = null;
        if (browser == Browser.IE) {
            iDriver = new InternetExplorerDriver();
        } else if (browser == Browser.CHROME) {
            iDriver = new ChromeDriver();
        } else if (browser == Browser.SAFARI) {
            iDriver = new SafariDriver();
        } else if (browser == Browser.ANDROID) {
            iDriver = new AndroidDriver();
        } else {
            iDriver = new FirefoxDriver();
        }

        System.out.println("use driver " + iDriver);

        return iDriver;
    }

    protected void openUrl() {
        openUrl(getBaseUrl());
    }

    protected void openUrl(String baseUrl) {
        System.out.println("open url " + baseUrl);
        driver.navigate().to(baseUrl);
    }

    public void clickOrTap(WebElement element) {
        if (driver instanceof SelendroidDriver) {
            TouchActions touchActions = new TouchActions((SelendroidDriver) driver);
            touchActions.singleTap(element);
            touchActions.perform();
        } else {
            element.click();
        }
    }

    @After
    public void saveScreenshotAndCloseBrowser() throws IOException {
        System.out.println("@After start");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        System.out.println("@After done");
    }

}
