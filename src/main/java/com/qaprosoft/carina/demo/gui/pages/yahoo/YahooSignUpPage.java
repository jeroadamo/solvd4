package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooSignUpPage extends AbstractPage {

    @FindBy(id = "usernamereg-firstName")
    private ExtendedWebElement firstName;
    @FindBy(id = "usernamereg-lastName")
    private ExtendedWebElement lastName;
    @FindBy(id = "usernamereg-userId")
    private ExtendedWebElement newMail;
    @FindBy(id = "usernamereg-password")
    private ExtendedWebElement password;
    @FindBy(id = "usernamereg-birthYear")
    private ExtendedWebElement birthYear;
    @FindBy(id = "reg-submit-button")
    private ExtendedWebElement confirmButton;

    public YahooSignUpPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://login.yahoo.com/account/create?.lang=es-AR&src=homepage&activity=ybar-signin&pspid=2142990676&.done=https%3A%2F%2Fespanol.yahoo.com%2F%3Fp%3Dus&specId=yidregsimplified&done=https%3A%2F%2Fespanol.yahoo.com%2F%3Fp%3Dus");
    }

    public void userCreation(){
        firstName.type(StringGenerator.generateWord(6));
        lastName.type(StringGenerator.generateWord(6));
        newMail.type(StringGenerator.generateWord(7));
        password.type(StringGenerator.generateWord(8));
        birthYear.type(StringGenerator.generateNumeric(4));
        confirmButton.click();
    }

    public boolean wasUserCreated(){
        return confirmButton.isElementPresent();
    }
}
