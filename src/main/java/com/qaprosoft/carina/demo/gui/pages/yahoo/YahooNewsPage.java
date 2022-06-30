package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YahooNewsPage extends AbstractPage {
    @FindBy(id = "ybar-navigation")
    private List<ExtendedWebElement> navigationBar;

    @FindBy(id = "Main")
    private List<ExtendedWebElement> mainElement;

    public YahooNewsPage(WebDriver driver) {
        super(driver);
    }
}
