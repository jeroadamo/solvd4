package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooWeatherPage extends AbstractPage {

    @FindBy(css = ".Py\\(4px\\).Px\\(10px\\).D\\(ib\\)")
    private ExtendedWebElement changeLocation;
    @FindBy(xpath = ".//div[@class='Pt(20px) Px(20px)']/header/input")
    private ExtendedWebElement locationSearchbar;
    @FindBy(css = "svg.Pos\\(a\\).T\\(7px\\).Start\\(7px\\).Cur\\(p\\)")
    private ExtendedWebElement firstResult;
    @FindBy(xpath = ".//div[@class='unit-control D(ib)']/button[1]")
    private ExtendedWebElement celciusButton;


    public YahooWeatherPage(WebDriver driver) {
        super(driver);
    }

    public void changeLocation(String city){
        changeLocation.click();
        locationSearchbar.type(city);
        firstResult.click();
    }

    public void changeToCelcius(){
        celciusButton.click();
    }

}
