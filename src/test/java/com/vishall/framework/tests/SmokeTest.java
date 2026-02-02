package com.vishall.framework.tests;

import com.vishall.framework.base.BaseTest;
import com.vishall.framework.driver.DriverFactory;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {
    @Test(groups={"smoke"})
    public void verifyAppLaunchandURLOpen() {
        String url = DriverFactory.getDriver().getCurrentUrl();
        System.out.println(url);
    }
}
