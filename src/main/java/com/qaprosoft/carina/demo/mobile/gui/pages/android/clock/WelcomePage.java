package com.qaprosoft.carina.demo.mobile.gui.pages.android.clock;


import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import org.openqa.selenium.WebDriver;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage implements IMobileUtils {
    @FindBy(id = "com.google.android.apps.nexuslauncher:id/hotseat")
    private ExtendedWebElement hotSeat;
    @FindBy(id = "com.google.android.apps.nexuslauncher:id/date")
    private ExtendedWebElement dateButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return dateButton.isElementPresent();
    }

    public AppsPage swipeToAppsPage(){
        swipe(244,755, 245,333, 100);
        return new AppsPage(getDriver());
    }

}
