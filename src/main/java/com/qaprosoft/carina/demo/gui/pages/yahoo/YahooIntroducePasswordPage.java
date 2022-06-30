package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooIntroducePasswordPage extends AbstractPage {

    @FindBy(id = "password-label")
    private ExtendedWebElement passwordBar;
    @FindBy(id = "login-signin")
    private ExtendedWebElement nextButton;
    @FindBy(xpath = ".//div[@class='input-group password-container focussed']/input[1]")
    private ExtendedWebElement passwordBarFocused;

    public YahooIntroducePasswordPage(WebDriver driver) {
        super(driver);
        String logInUrl = Configuration.getEnvArg("login_url");
        setPageAbsoluteURL(logInUrl+"account/challenge/password?.lang=es-AR&src=homepage&pspid=2142990676&activity=ybar-signin&done=https%3A%2F%2Fespanol.yahoo.com%2F&sessionIndex=QQ--&acrumb=nq2oerwP&display=login&authMechanism=primary");
    }

    public void introducePassword(String password){
        passwordBarFocused.type(password);
    }

    public YahooHomepage next(){
        nextButton.click();
        return new YahooHomepage(driver);
    }
}
