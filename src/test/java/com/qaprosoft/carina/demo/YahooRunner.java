package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.yahoo.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YahooRunner implements IAbstractTest {
    @Test()
    public void clickSomeThangInThaPageBro(){
        YahooHomepage yahooHomepage = new YahooHomepage(getDriver());
        yahooHomepage.openURL("https://espanol.yahoo.com/",500);
        Assert.assertTrue(yahooHomepage.isPageOpened(), "Not opende");

        yahooHomepage = new YahooHomepage(getDriver());
        YahooNews somePage = yahooHomepage.clickNews();
    }
    @Test
    public void createUser() throws InterruptedException {
        YahooHomepage yahooHomepage = new YahooHomepage(getDriver());
        yahooHomepage.open();
        yahooHomepage = new YahooHomepage(getDriver());
        YahooLogin yahooLogin = yahooHomepage.clickLogin();
        YahooSignUp yahooSignUp = yahooLogin.clickSignup();
        yahooSignUp.writeFn("Pickle");
        yahooSignUp.writeLn("Rick");
        yahooSignUp.setNewMail("picklerico29");
        yahooSignUp.setPassword("Gombelson99");
        yahooSignUp.setBirthYear("1999");
        yahooSignUp.clickConfirm();
    }

    @Test
    public void searchAndGetFirstImage(){
        YahooHomepage yahooHomepage = new YahooHomepage(getDriver());
        yahooHomepage.open();
        yahooHomepage = new YahooHomepage(getDriver());
        YahooSearchEngine yahooSearchEngine = yahooHomepage.searchSomething("dogs");
        YahooSearchImages yahooSearchImages = yahooSearchEngine.getImages();
        yahooSearchImages.clickFirstResult();
    }

    @Test
    public void checkWeatherInSomeCity(){
        YahooHomepage yahooHomepage= new YahooHomepage(getDriver());
        yahooHomepage.open();
        yahooHomepage = new YahooHomepage(getDriver());
        YahooWeatherPage yahooWeatherPage = yahooHomepage.weatherPage();
        yahooWeatherPage.changeLocation("varsovia, polonia");
        yahooWeatherPage.changeToCelcius();
    }
    @Test
    public void checkMail(){
        YahooHomepage yahooHomepage = new YahooHomepage(getDriver());
        yahooHomepage.open();
        yahooHomepage=new YahooHomepage(getDriver());
        YahooLogin yahooLogin = yahooHomepage.clickLogin();
        yahooLogin.typeMail("picklerico29@yahoo.com");
//        yahooLogin.uncheckStayConnected();
        YahooIntroducePassword yahooIntroducePassword = yahooLogin.clickNext();
        yahooIntroducePassword.introducePassword("solvdtest21");
        YahooHomepage yahooHomepage1 = yahooIntroducePassword.next();
        YahooMailPage yahooMailPage = yahooHomepage1.mailPage();
    }
}
