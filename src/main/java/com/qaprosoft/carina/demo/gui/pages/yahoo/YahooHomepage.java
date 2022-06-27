package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class YahooHomepage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(name = "p")
    private ExtendedWebElement searchbar;

    @FindBy(id = "ybar-search")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = ".//div[@class='_yb_142c6 _yb_1upl7 ']/div/div/ul/li[3]/a[1]")
    private ExtendedWebElement news;
    @FindBy(css = "a#root_8")
    private ExtendedWebElement weather;
    @FindBy(css = "a._yb_1k4wk")
    private ExtendedWebElement loginButton;
    @FindBy(css = "a._yb_13wsn.rapid-noclick-resp")
    private ExtendedWebElement mail;



    public YahooHomepage(WebDriver driver) {
        super(driver);
//        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }
    public YahooNews clickNews() {
        news.click();
        return new YahooNews(driver);
    }

    public YahooLogin clickLogin(){
        loginButton.click();
        return new YahooLogin(driver);
    }

    public YahooSearchEngine searchSomething(String text){
        searchbar.click();
        searchbar.type(text);
        searchButton.click();
        return new YahooSearchEngine(driver);
    }

    public YahooWeatherPage weatherPage(){
        weather.click();
        return new YahooWeatherPage(driver);
    }

    public YahooMailPage mailPage(){
        mail.click();
        return new YahooMailPage(driver);
    }
}
