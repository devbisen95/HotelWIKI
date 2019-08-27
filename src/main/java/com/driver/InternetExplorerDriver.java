package com.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class InternetExplorerDriver extends AbstractDriver {

    @Override
    public RemoteWebDriver launchDriver(URL serverUrl, String applicationUrl, Platform platform, Proxy proxy) {
        capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(CapabilityType.PLATFORM, platform);
        capabilities.setCapability(org.openqa.selenium.ie.InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        if( proxy != null) {
            capabilities.setCapability(CapabilityType.PROXY, proxy);
        }
        return launchBrowser(serverUrl, applicationUrl);
    }
}
