package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooSearchEnginePage extends AbstractPage {

    @FindBy(id = "yschsp")
    private ExtendedWebElement searchbar;
    @FindBy(id = "logo")
    private ExtendedWebElement backToYahooButton;
    @FindBy(xpath = ".//div[@class='compList visible-pivots fl-l  ']/ul/li[2]/a[1]")
    private ExtendedWebElement imagesButton;


    public YahooSearchEnginePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(backToYahooButton);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
//        setPageAbsoluteURL("https://ar.search.yahoo.com/search?p=cats&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1");
    }

    public YahooSearchImages clickImagesButton(){
        imagesButton.click();
        return new YahooSearchImages(driver);
    }

    public YahooHomepage goBackToYahoo(){
        backToYahooButton.click();
        return new YahooHomepage(driver);
    }

}
