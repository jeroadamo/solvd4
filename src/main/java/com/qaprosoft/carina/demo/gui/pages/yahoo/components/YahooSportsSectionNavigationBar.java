package com.qaprosoft.carina.demo.gui.pages.yahoo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooSportsSectionNavigationBar extends AbstractUIObject {
    @FindBy(id = "root_1")
    private ExtendedWebElement mexicanLeagueButton;
    @FindBy(id = "root_2")
    private ExtendedWebElement laLigaButton;
    @FindBy(id = "root_3")
    private ExtendedWebElement futbolButton;
    @FindBy(id = "root_4")
    private ExtendedWebElement nflButton;

    public YahooSportsSectionNavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickMXLeague(){
        mexicanLeagueButton.click();
    }

    public void clickSpanishLeague(){
        laLigaButton.click();
    }

    public void clickFutbolGeneral(){
        futbolButton.click();
    }

    public void clickNflButton(){
        nflButton.click();
    }
}
