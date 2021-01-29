package test_utils.homepage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import stoic_studio.pageobjects.HomePageObject;

public class HomePageUtility {
    HomePageObject homePageObject;

    public void verifyThePresenceOfHomePageTitle(WebDriver webDriver){
        homePageObject = new HomePageObject(webDriver);
        String pageTitle = homePageObject.getPageTitle();
        Assert.assertTrue(pageTitle.equals(HomePageItems.HOME_PAGE_TITLE),String.format(" <%s> is the actual " +
                "displayed page title"));
    }

    public void verifyUserCanSubscribe(WebDriver webDriver){
        homePageObject = new HomePageObject(webDriver);
        homePageObject.enterEmailID("SampleEmail@email.com");
        homePageObject.clickSubscribeButton();
    }

    public void verifyTheNavbarOptions(WebDriver webDriver){
        homePageObject = new HomePageObject(webDriver);
    }
}
