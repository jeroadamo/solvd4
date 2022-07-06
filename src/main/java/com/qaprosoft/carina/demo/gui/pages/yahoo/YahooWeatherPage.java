package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooWeatherPage extends AbstractPage {

    @FindBy(xpath = ".//div[@class='StretchedBox']/section[1]/div[2]/div[1]/button[1]/div[1]/span")
    private ExtendedWebElement changeLocationButton;
    @FindBy(xpath = ".//input[@placeholder='Introducir la ciudad o el código postal']")
    private ExtendedWebElement locationSearchbar;
    @FindBy(xpath = ".//div[@class='D(tb) W(100%)']/button")
    private ExtendedWebElement firstResult;
    @FindBy(xpath = ".//div[@class='unit-control D(ib)']/button[1]")
    private ExtendedWebElement celciusButton;
    @FindBy(xpath = ".//button[@aria-label='°Centígrados']")
    private ExtendedWebElement celciusDisplay;


    public YahooWeatherPage(WebDriver driver) {
        super(driver);
        String weatherUrl = Configuration.getEnvArg("weather_url");
        setPageAbsoluteURL(weatherUrl+"clima/");
    }

    public void changeLocation(String city){
        changeLocationButton.click();
        locationSearchbar.type(city);
        firstResult.click();
    }

    public void changeToCelcius(){
        celciusButton.click();
    }

    public boolean isChangedToCelcius(){
        return celciusDisplay.isElementPresent();
    }

}
