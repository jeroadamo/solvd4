package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooSearchImages extends AbstractPage {

    @FindBy(id = "yschsp")
    private ExtendedWebElement searchBar;
    @FindBy(css = "span#yui_3_5_1_1_1656298224032_808")
    private ExtendedWebElement changeSizeButton;
    @FindBy(css = "li#resitem-0")
    private ExtendedWebElement firstResult;


    public YahooSearchImages(WebDriver driver) {
        super(driver);
    }

    public void clickFirstResult(){
        firstResult.click();
    }

    public boolean isFirstResultOpened(){
        return firstResult.isElementPresent();
    }
}
