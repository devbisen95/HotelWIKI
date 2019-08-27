package com.driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public abstract class AbstractDriver implements IDriver{

    DesiredCapabilities capabilities;

    RemoteWebDriver remoteDriver;

    protected RemoteWebDriver launchBrowser(URL serverUrl, String applicationUrl) {
        System.out.println("Launching browser start " + serverUrl + " " + applicationUrl);
        System.out.println("capabilities :"+ capabilities.getBrowserName()+"   "+capabilities.getVersion()+ "     "+capabilities.getPlatform().name());
        remoteDriver = createWebDriver(serverUrl, capabilities);
        System.out.println("Launching browser " + remoteDriver);
        remoteDriver.navigate().to(applicationUrl);
        System.out.println("Launching browser done");
        return remoteDriver;
    }

    protected RemoteWebDriver createWebDriver(URL serverUrl, DesiredCapabilities capabilities) {
        return new RemoteWebDriver(serverUrl, capabilities);
    }
}
