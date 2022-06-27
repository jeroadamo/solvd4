package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.print.DocFlavor;

public class YahooSignUp extends AbstractPage {

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
    private ExtendedWebElement confirm;

    public YahooSignUp(WebDriver driver) {
        super(driver);
    }

    public void writeFn(String fn){
        firstName.click();
        firstName.type(fn);
    }

    public void writeLn(String ln){
        lastName.click();
        lastName.type(ln);
    }
    public void setNewMail(String mail){
        newMail.click();
        newMail.type(mail);
    }
    public void setPassword(String pw){
        password.click();
        password.type(pw);
    }
    public void setBirthYear(String by){
        birthYear.click();
        birthYear.type(by);
    }

    public void clickConfirm(){
        confirm.click();
    }
}
