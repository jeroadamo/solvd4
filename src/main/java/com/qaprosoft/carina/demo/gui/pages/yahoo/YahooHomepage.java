package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class YahooHomepage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(name = "p")
    private ExtendedWebElement searchbar;
    @FindBy(id = "ybar-search")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = ".//div[@id='ybar-navigation']/div[1]/ul[1]/li[3]/a[1]")
    private ExtendedWebElement newsButton;
    @FindBy(css = "a#root_8")
    private ExtendedWebElement weatherButton;
    @FindBy(xpath = ".//div[@role='toolbar']/div[1]/div[1]/a")
    private ExtendedWebElement loginButton;
    @FindBy(css = "a#ybarMailLink")
    private ExtendedWebElement mailButton;
    @FindBy(id = "root_3")
    private ExtendedWebElement sportsButton;
    @FindBy(xpath = ".//div[@class='bd']/div[1]/div[1]/div")
    private List<ExtendedWebElement> leftTrendingTopics;


    public YahooHomepage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }
    public YahooNewsPage clickNews() {
        newsButton.click();
        return new YahooNewsPage(driver);
    }

    public YahooLoginPage clickLogin(){
        loginButton.click();
        return new YahooLoginPage(driver);
    }

    public YahooSearchEnginePage searchSomething(String text){
        searchbar.type(text);
        searchButton.click();
        return new YahooSearchEnginePage(driver);
    }

    public YahooWeatherPage goToWeatherPage(){
        weatherButton.click();
        return new YahooWeatherPage(driver);
    }

    public YahooMailPage goToMailPage(){
        mailButton.click();
        return new YahooMailPage(driver);
    }

    public YahooSearchEnginePage clickOnTrendingTopic(int topicNumber){
      leftTrendingTopics.get(topicNumber).click();
      return new YahooSearchEnginePage(driver);
    }

    public YahooSportsPage goToYahooSports(){
        sportsButton.click();
        return new YahooSportsPage(getDriver());
    }
}
