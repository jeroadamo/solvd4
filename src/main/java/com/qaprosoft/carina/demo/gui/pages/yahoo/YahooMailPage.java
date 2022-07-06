package com.qaprosoft.carina.demo.gui.pages.yahoo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooMailPage extends AbstractPage {
    @FindBy(xpath = ".//a[@aria-label='Compose']")
    private ExtendedWebElement composeButton;
    @FindBy(xpath = ".//a[@data-test-id='smartview-list-item']")
    private ExtendedWebElement unreadFolder;
    @FindBy(xpath = ".//a[@aria-label='Unread, selected - Showing unread mails']")
    private ExtendedWebElement unreadFolderOpened;


    public YahooMailPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://mail.yahoo.com/d/folders/1?.intl=e1&.lang=es-US&.partner=none&.src=fp");
    }

    public void clickUnreadEmails(){
        unreadFolder.click();
    }

    public boolean isUnreadFolderOpened(){
        return unreadFolderOpened.isElementPresent();
    }
}
