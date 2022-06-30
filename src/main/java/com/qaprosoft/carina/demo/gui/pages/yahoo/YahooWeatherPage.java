package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooWeatherPage extends AbstractPage {

    @FindBy(css = ".Py\\(4px\\).Px\\(10px\\).D\\(ib\\)")
    private ExtendedWebElement changeLocationButton;
    @FindBy(xpath = ".//div[@class='Pt(20px) Px(20px)']/header/input")
    private ExtendedWebElement locationSearchbar;
    @FindBy(css = "svg.Pos\\(a\\).T\\(7px\\).Start\\(7px\\).Cur\\(p\\)")
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
