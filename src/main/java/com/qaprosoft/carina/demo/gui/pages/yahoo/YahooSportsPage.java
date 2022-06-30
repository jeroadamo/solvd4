package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.yahoo.components.YahooSportsSectionNavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooSportsPage extends AbstractPage {

    @FindBy(id = "ybar-navigation")
    private YahooSportsSectionNavigationBar navigationBar;
    @FindBy(xpath = ".//div[@id='Lead-1-ScoreStrip-Proxy']/div[1]/div[1]/div[1]/div[1]/div[1]")
    private ExtendedWebElement resultsDisplay;

    public YahooSportsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://es-us.deportes.yahoo.com/");
    }

    public void goToSpanishLeague(){
        navigationBar.clickSpanishLeague();
    }

    public void goToNfl(){
        navigationBar.clickNflButton();
    }

    public boolean isResultsDisplayPresent(){
        return resultsDisplay.isElementPresent();
    }
}
