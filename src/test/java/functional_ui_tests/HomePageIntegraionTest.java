package functional_ui_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test_utils.AbstractTestUtils;
import test_utils.TestConstants;
import test_utils.WebDriverType;
import test_utils.homepage.HomePageItems;
import test_utils.homepage.HomePageUtility;

public class HomePageIntegraionTest {
    public WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        this.webDriver = AbstractTestUtils.initWebDriver(WebDriverType.FIREFOX);
        webDriver.get(TestConstants.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    @Test
    public void verifyTheHomePageTittle() {
        HomePageUtility.verifyThePresenceOfHomePageTitle(webDriver);
    }

    @Test
    public void verifyTheNavbarText() {
        HomePageUtility.verifyTheNavbarOptions(webDriver, HomePageItems.NEWS);
        HomePageUtility.verifyTheNavbarOptions(webDriver, HomePageItems.ABOUT_US);
        HomePageUtility.verifyTheNavbarOptions(webDriver, HomePageItems.CONTACT);
        HomePageUtility.verifyTheNavbarOptions(webDriver, HomePageItems.STORE);
        HomePageUtility.verifyTheNavbarOptions(webDriver, HomePageItems.DISCORD);
    }

    @Test
    public void verifyUserCanSubcribe() {
        HomePageUtility.verifyUserCanSubscribe(webDriver, TestConstants.SUBSCRIBER_EMAIL);
    }


}
