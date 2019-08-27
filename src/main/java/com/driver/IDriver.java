package com.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public interface IDriver {

        RemoteWebDriver launchDriver(URL serverUrl, String applicationUrl, Platform platform, Proxy proxy);
    }

