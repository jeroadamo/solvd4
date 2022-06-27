package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooIntroducePassword extends AbstractPage {

    @FindBy(id = "password-label")
    private ExtendedWebElement passwordBar;
    @FindBy(id = "login-signin")
    private ExtendedWebElement nextButton;
    @FindBy(xpath = ".//div[@class='input-group password-container focussed']/input[1]")
    private ExtendedWebElement passwordBarFocused;

    public YahooIntroducePassword(WebDriver driver) {
        super(driver);
    }

    public void introducePassword(String password){
        passwordBarFocused.type(password);
    }

    public YahooHomepage next(){
        nextButton.click();
        return new YahooHomepage(driver);
    }
}
