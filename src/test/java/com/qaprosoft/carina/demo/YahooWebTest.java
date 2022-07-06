package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.pages.yahoo.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YahooWebTest implements IAbstractTest {

    @Test
    public void testUserCreation() throws InterruptedException {
        YahooHomepage yahooHomepage = new YahooHomepage(getDriver());
        yahooHomepage.open();
        Assert.assertTrue(yahooHomepage.isPageOpened(), "Failed to open Yahoo homepage.");
        YahooLoginPage yahooLoginPage = yahooHomepage.clickLogin();
        Assert.assertTrue(yahooLoginPage.isPageOpened(), "Failed to open Yahoo login page.");
        YahooSignUpPage yahooSignUpPage = yahooLoginPage.clickSignup();
        Assert.assertTrue(yahooSignUpPage.isPageOpened(),"Failed to open Yahoo signup page.");
        yahooSignUpPage.userCreation();
        Assert.assertTrue(yahooSignUpPage.wasUserCreated(), "Yahoo user failed creation");
    }

    @Test
    public void testSearchAndClickFirstImage(){
        YahooHomepage yahooHomepage = new YahooHomepage(getDriver());
        yahooHomepage.open();
        Assert.assertTrue(yahooHomepage.isPageOpened(), "Failed to load Yahoo homepage.");
        YahooSearchEnginePage yahooSearchEnginePage = yahooHomepage.searchSomething(R.TESTDATA.get("searchWord"));
        Assert.assertTrue(yahooSearchEnginePage.isPageOpened(), "Failed to open Yahoo search page.");
        YahooSearchImages yahooSearchImages = yahooSearchEnginePage.clickImagesButton();
        yahooSearchImages.assertPageOpened();
        yahooSearchImages.clickFirstResult();
        Assert.assertTrue(yahooSearchImages.isFirstResultOpened(), "First image wasn't successfully opened.");
    }

    @Test
    public void testCheckWeatherInSomeCity(){
        YahooHomepage yahooHomepage= new YahooHomepage(getDriver());
        yahooHomepage.open();
        Assert.assertTrue(yahooHomepage.isPageOpened(), "Failed to open Yahoo homepage.");
        YahooWeatherPage yahooWeatherPage = yahooHomepage.goToWeatherPage();
        Assert.assertTrue(yahooWeatherPage.isPageOpened(), "Failed to open Yahoo weather page");
        yahooWeatherPage.changeLocation(R.TESTDATA.get("city"));
        yahooWeatherPage.changeToCelcius();
        Assert.assertTrue(yahooWeatherPage.isChangedToCelcius(), "The temperature is not displaying in celcius degrees.");

    }
    @Test
    public void testCheckMail(){
        YahooHomepage yahooHomepage = new YahooHomepage(getDriver());
        yahooHomepage.open();
        Assert.assertTrue(yahooHomepage.isPageOpened(), "Failed to open Yahoo homepage.");
        YahooLoginPage yahooLoginPage = yahooHomepage.clickLogin();
        Assert.assertTrue(yahooLoginPage.isPageOpened(), "Failed to open Yahoo login page.");
        yahooLoginPage.typeMail(R.TESTDATA.get("email"));
        YahooIntroducePasswordPage yahooIntroducePasswordPage = yahooLoginPage.clickNext();
        Assert.assertTrue(yahooIntroducePasswordPage.isPageOpened(), "Failed to open Yahoo introduce password page.");
        yahooIntroducePasswordPage.introducePassword(R.TESTDATA.get("password"));
        YahooHomepage yahooHomepage1 = yahooIntroducePasswordPage.next();
        YahooMailPage yahooMailPage = yahooHomepage1.goToMailPage();
        Assert.assertTrue(yahooMailPage.isPageOpened(), "Failed to open mail page");
        yahooMailPage.clickUnreadEmails();
        Assert.assertTrue(yahooMailPage.isUnreadFolderOpened(), "Unread folder not opened.");
    }

    @Test()
    public void testTrendingTopicAndSportsPage(){
        YahooHomepage yhp = new YahooHomepage(getDriver());
        yhp.open();
        Assert.assertTrue(yhp.isPageOpened(), "Failed to open Yahoo homepage.");
        YahooSearchEnginePage yahooSearchEnginePage = yhp.clickOnTrendingTopic(2);
        yhp = yahooSearchEnginePage.goBackToYahoo();
        Assert.assertTrue(yhp.isPageOpened(), "Failed to open Yahoo homepage");
        YahooSportsPage yahooSportsPage = yhp.goToYahooSports();
        Assert.assertTrue(yahooSportsPage.isPageOpened(), "Failed to open yahoo sports page");
        yahooSportsPage.goToNfl();
        yahooSportsPage.goToSpanishLeague();
        Assert.assertTrue(yahooSportsPage.isResultsDisplayPresent(), "No results for La Liga currently displaying");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/yahooUrls.xlsx", sheet = "Sheet1", dsUid = "TUID", dsArgs = "Domain, RestOfUrl, Url")
    public void testUrlFormation(String domain, String restOfUrl, String url){

        String parts = String.valueOf(domain) + String.valueOf(restOfUrl);
        String wholeUrl = String.valueOf(url);
        Assert.assertEquals(parts, wholeUrl, "Url not matching");

        YahooNewsPage yahooNewsPage = new YahooNewsPage(getDriver());
        yahooNewsPage.openURL(wholeUrl);
        Assert.assertTrue(yahooNewsPage.isPageOpened(), "Failed to open Yahoo news page");
    }
}
