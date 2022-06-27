package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooLogin extends AbstractPage {

    @FindBy(className = "login-box right")
    private ExtendedWebElement loginBox;

    @FindBy(css = "a#createacc")
    private ExtendedWebElement createUser;
    @FindBy(id = "login-username")
    private ExtendedWebElement loginBar;
    @FindBy(css = "input#persistent")
    private ExtendedWebElement checkbox;
    @FindBy(id = "login-signin")
    private ExtendedWebElement next;


    public YahooLogin(WebDriver driver) {
        super(driver);
    }

    public YahooSignUp clickSignup(){
        createUser.click();
        return new YahooSignUp(driver);
    }

    public void uncheckStayConnected(){
        checkbox.uncheck();
    }

    public void typeMail(String text){
        loginBar.click();
        loginBar.type(text);
    }

    public YahooIntroducePassword clickNext(){
        next.click();
        return new YahooIntroducePassword(driver);
    }
}
