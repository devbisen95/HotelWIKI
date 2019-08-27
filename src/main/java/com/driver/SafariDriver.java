package com.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SafariDriver extends AbstractDriver {

    @Override
    public RemoteWebDriver launchDriver(URL serverUrl, String applicationUrl, Platform platform, Proxy proxy) {
        capabilities = DesiredCapabilities.safari();
        capabilities.setCapability("safari.autostart ", true);
        capabilities.setCapability(CapabilityType.PLATFORM, platform);
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        return launchBrowser(serverUrl, applicationUrl);
    }

}
