package com.driver;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class AndroidDriver extends AbstractDriver{

    @Override
    public RemoteWebDriver launchDriver(URL serverUrl, String applicationUrl, Platform platform, Proxy proxy) {

        // Create object of  DesiredCapabilities class and specify android platform
        capabilities = DesiredCapabilities.android();

        // set the capability to execute test in chrome browser
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

        // set the capability to execute our test in Android Platform
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

        // we need to define platform name
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        // Set the device name as well (you can give any name)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "my phone");

        // set the android version as well
        capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");



        if( proxy != null) {
            capabilities.setCapability(CapabilityType.PROXY, proxy);
        }

        return launchBrowser(serverUrl, applicationUrl);
    }

    @Override
    protected RemoteWebDriver createWebDriver(URL serverUrl, DesiredCapabilities capabilities) {
        return new SelendroidDriver(serverUrl, capabilities);
    }
}
