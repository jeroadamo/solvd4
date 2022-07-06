package com.qaprosoft.carina.demo.mobile.gui.pages.android.clock;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Clock;

public class AppsPage extends AbstractPage implements IMobileUtils {
    @FindBy(xpath = "//android.widget.TextView[@content-desc='Clock']")
    private ExtendedWebElement clockApp;
    @FindBy(xpath = "//android.widget.TextView[@content-desc='Camera']")
    private ExtendedWebElement cameraApp;

    public boolean isPageOpened(){
        return cameraApp.isElementPresent();
    }

    public ClockAppPage openClock(){
        clockApp.click();
        return new ClockAppPage(getDriver());
    }
    public AppsPage(WebDriver driver) {
        super(driver);
    }
}
