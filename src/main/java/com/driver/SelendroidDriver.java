package com.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;

import java.net.URL;

public class SelendroidDriver extends io.appium.java_client.android.AndroidDriver implements HasTouchScreen {

    public RemoteTouchScreen touch;

    public SelendroidDriver(URL remoteAddress,
                            Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }

    public TouchScreen getTouch() {
        return touch;
    }
}
