package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooSearchEngine extends AbstractPage {

    @FindBy(id = "yschsp")
    private ExtendedWebElement searchbar;
    @FindBy(css = "a.d-ib.ls-05.fz-20.lh-26.td-hu.tc.va-bot.mxw-100p")
    private ExtendedWebElement firstResult;
    @FindBy(id = "logo")
    private ExtendedWebElement backToYahoo;
    @FindBy(xpath = ".//div[@class='compList visible-pivots fl-l  ']/ul/li[2]/a[1]")
    private ExtendedWebElement images;


    public YahooSearchEngine(WebDriver driver) {
        super(driver);
    }

    public YahooSearchImages getImages(){
        images.click();
        return new YahooSearchImages(driver);
    }
}
