package com.qaprosoft.carina.demo.mobile.gui.pages.android.clock;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.sun.xml.bind.v2.model.core.ID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ClockAppPage extends AbstractPage implements IMobileUtils {
    @FindBy(id = "com.google.android.deskclock:id/digital_clock")
    private ExtendedWebElement digitalClock;
    @FindBy(id = "com.google.android.deskclock:id/tab_menu_alarm")
    private ExtendedWebElement alarmsDisplay;
    @FindBy(xpath = "//androidx.cardview.widget.CardView[@content-desc='8:30 AM Alarm']/android.view.ViewGroup/android.widget.Switch")
    private ExtendedWebElement setAlarmButton;
    @FindBy(id = "com.google.android.deskclock:id/choose_ringtone")
    private ExtendedWebElement chooseRingtoneButton;

    public ClockAppPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return digitalClock.isElementPresent();
    }

    public boolean isChooseRingtonePresent(){
        return chooseRingtoneButton.isElementPresent();
    }
    public void set0830Alarm(){
        alarmsDisplay.click();
        setAlarmButton.click();
    }
}
