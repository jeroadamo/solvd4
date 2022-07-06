package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooSearchImages extends AbstractPage {

    @FindBy(id = "yschsp")
    private ExtendedWebElement searchBar;
    @FindBy(xpath = ".//ul[@id='sres']/li[1]")
    private ExtendedWebElement firstResult;


    public YahooSearchImages(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchBar);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void clickFirstResult(){
        firstResult.click();
    }

    public boolean isFirstResultOpened(){
        return firstResult.isElementPresent();
    }
}
