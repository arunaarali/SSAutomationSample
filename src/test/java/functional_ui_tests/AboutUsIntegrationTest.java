package functional_ui_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test_utils.AbstractTestUtils;
import test_utils.TestConstants;
import test_utils.WebDriverType;
import test_utils.aboutus.AboutUsPageUtility;
import test_utils.aboutus.TeamMembersName;
import test_utils.homepage.HomePageUtility;

public class AboutUsIntegrationTest {
    public WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        this.webDriver = AbstractTestUtils.initWebDriver(WebDriverType.FIREFOX);
        webDriver.get(TestConstants.BASE_URL);
        HomePageUtility.navigateToAboutusPage(webDriver);
    }

    @AfterMethod
    public void tearDown(){
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    @Test
    public void verifyTheAboutUsPageHeader() {
        AboutUsPageUtility.existenceOfAboutUsPageHeader(webDriver);
    }

    @Test
    public void verifyExistenceOfTeamMember(){
        AboutUsPageUtility.verifyExistenceOfTeamMemberInAboutUsPage(webDriver, TeamMembersName.ALEX_THOMAS);
        AboutUsPageUtility.verifyExistenceOfTeamMemberInAboutUsPage(webDriver, TeamMembersName.ARNIE_JORGENSEN);
        AboutUsPageUtility.verifyExistenceOfTeamMemberInAboutUsPage(webDriver, TeamMembersName.JOHN_WATSON);
        AboutUsPageUtility.verifyExistenceOfTeamMemberInAboutUsPage(webDriver, TeamMembersName.MATT_BERNEY);
        AboutUsPageUtility.verifyExistenceOfTeamMemberInAboutUsPage(webDriver, TeamMembersName.TRISHA_STOUFFER);
    }
}
