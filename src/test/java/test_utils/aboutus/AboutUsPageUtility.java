package test_utils.aboutus;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import stoic_studio.pagefactory.PageObjectfactory;
import stoic_studio.pageobjects.AboutUsPageObject;
import test_utils.AbstractTestUtils;

@Slf4j
public class AboutUsPageUtility extends AbstractTestUtils {
    private static AboutUsPageObject aboutUsPageObject;

    /**
     * Method expects to be on About us page.
     *
     * @param webDriver Supported web browser.
     */
    public static void existenceOfAboutUsPageHeader(WebDriver webDriver) {
        aboutUsPageObject = PageObjectfactory.createAboutUsPageObject(webDriver);
        Assert.assertTrue(aboutUsPageObject.isPageVisible(), String.format("Expected <%s> page object is not visible.",
                aboutUsPageObject.getClass().getSimpleName()));
        Assert.assertTrue(aboutUsPageObject.aboutUsHeaderDisplayed());
    }

    /**
     * Method expects to be on About us page.
     *
     * @param webDriver       Supported web browser.
     * @param teamMembersName team member full name to match.
     */
    public static void verifyExistenceOfTeamMemberInAboutUsPage(WebDriver webDriver, TeamMembersName teamMembersName) {
        aboutUsPageObject = PageObjectfactory.createAboutUsPageObject(webDriver);
        Assert.assertTrue(aboutUsPageObject.isPageVisible(), String.format("Expected <%s> page object is not visible.",
                aboutUsPageObject.getClass().getSimpleName()));
        for (String teamMember : aboutUsPageObject.getMembersName()) {
            if (teamMembersName.getFullName.equalsIgnoreCase(teamMember)) {
                log.info("Verifying the presence of Team member <{}>.", teamMembersName.getFullName);
                Assert.assertTrue(teamMembersName.getFullName.equalsIgnoreCase(teamMember));
                break;
            }
        }
    }
}
