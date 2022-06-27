package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YahooNews extends AbstractPage {
    @FindBy(id = "ybar-navigation")
    private List<ExtendedWebElement> navigationBar;

    @FindBy(id = "Main")
    private List<ExtendedWebElement> mainElement;

    public YahooNews(WebDriver driver) {
        super(driver);
    }
}
