package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooLoginPage extends AbstractPage {

    @FindBy(className = "login-box right")
    private ExtendedWebElement loginBox;
    @FindBy(id = "createacc")
    private ExtendedWebElement createNewUserButton;
    @FindBy(id = "login-username")
    private ExtendedWebElement loginBar;
    @FindBy(id = "login-signin")
    private ExtendedWebElement confirmButton;


    public YahooLoginPage(WebDriver driver) {
        super(driver);
        String logInUrl = Configuration.getEnvArg("login_url");
        setPageAbsoluteURL(logInUrl +"?.lang=es-AR&src=homepage&.done=https%3A%2F%2Fespanol.yahoo.com%2F&pspid=2142990676&activity=ybar-signin");
    }

    public YahooSignUpPage clickSignup(){
        createNewUserButton.click();
        return new YahooSignUpPage(driver);
    }

    public void typeMail(String text){
        loginBar.click();
        loginBar.type(text);
    }

    public YahooIntroducePasswordPage clickNext(){
        confirmButton.click();
        return new YahooIntroducePasswordPage(driver);
    }

}
