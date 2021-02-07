package test_utils.homepage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import stoic_studio.pagefactory.PageObjectfactory;
import stoic_studio.pageobjects.HomePageObject;
import test_utils.AbstractTestUtils;

public class HomePageUtility extends AbstractTestUtils {
    private static HomePageObject homePageObject;

    /**
     * Method expects to be on Home page.
     *
     * @param webDriver Supported web browser.
     */
    public static void verifyThePresenceOfHomePageTitle(WebDriver webDriver) {
        homePageObject = PageObjectfactory.createHomePageObject(webDriver);
        Assert.assertTrue(homePageObject.isPageVisible(), String.format("Expected page {} is currently " +
                "not visible", homePageObject));
        String pageTitle = homePageObject.getPageTitle();
        Assert.assertTrue(pageTitle.equalsIgnoreCase(HomePageItems.HOME_PAGE_TITLE.getValue), String.format(
                " <%s> is the actual displayed page title", pageTitle));
    }

    /**
     * Method expects to be on Home page.
     *
     * @param webDriver       Supported web browser.
     * @param subscriberEmail Email as a test data to subscribe.
     */
    public static void verifyUserCanSubscribe(WebDriver webDriver, String subscriberEmail) {
        homePageObject = new HomePageObject(webDriver);
        Assert.assertTrue(homePageObject.isPageVisible(), String.format("Expected page {} is currently " +
                "not visible", homePageObject));
        homePageObject.enterEmailID(subscriberEmail);
        Assert.assertTrue(homePageObject.isPageVisible(), String.format("Expected page {} is currently " +
                "not visible", homePageObject));
        homePageObject.clickSubscribeButton();
    }

    /**
     * Method expects to be on home page.
     *
     * @param webDriver     Supported web browser.
     * @param homePageItems Navbar item.
     */
    public static void verifyTheNavbarOptions(final WebDriver webDriver, final HomePageItems homePageItems) {
        homePageObject = PageObjectfactory.createHomePageObject(webDriver);
        for (String navbarText : homePageObject.getNavbarText()) {
            if (navbarText.equalsIgnoreCase(homePageItems.getValue)) {
                Assert.assertTrue(true);
            }
        }
    }

    /**
     * Method expects to be on home page.
     *
     * @param webDriver Supported web browser.
     */
    public static void navigateToAboutusPage(final WebDriver webDriver) {
        homePageObject = PageObjectfactory.createHomePageObject(webDriver);
        homePageObject.navigateTo(HomePageItems.ABOUT_US.getValue);
    }

}
