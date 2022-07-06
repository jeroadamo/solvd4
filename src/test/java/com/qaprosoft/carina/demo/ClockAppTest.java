package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.clock.AppsPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.clock.ClockAppPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.clock.WelcomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class ClockAppTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testSet830Alarm(){
        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page not opened");
        AppsPage appsPage = welcomePage.swipeToAppsPage();
        Assert.assertTrue(appsPage.isPageOpened(), "Failed to show all apps");
        ClockAppPage clockAppPage = appsPage.openClock();
        clockAppPage.isPageOpened();
        clockAppPage.set0830Alarm();
        Assert.assertTrue(clockAppPage.isChooseRingtonePresent(), "Failed to set alarm");    }
}
