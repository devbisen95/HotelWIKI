package com.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ChromeDriver extends AbstractDriver {

    @Override
    public RemoteWebDriver launchDriver(URL serverUrl, String applicationUrl, Platform platform, Proxy proxy) {
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.PLATFORM, platform);
        if( proxy != null) {
            System.out.println("setCapability PROXY:" + proxy.getHttpProxy());
            capabilities.setCapability(CapabilityType.PROXY, proxy);
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return launchBrowser(serverUrl, applicationUrl);
    }
}
