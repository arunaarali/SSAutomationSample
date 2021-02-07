package stoic_studio.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stoic_studio.PageObject;

import java.util.ArrayList;
import java.util.List;

public class AboutUsPageObject extends PageObject {

    @FindBy(id = "stoic_team_header")
    WebElement aboutUsPage_Header;

    @FindBy(xpath = "//div[@class='about_members']/div[contains(normalize-space(@class),\"one_third\")]")
    List<WebElement> teamMembers;

    public AboutUsPageObject(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public List<String> getMembersName() {
        List<String> membersName = new ArrayList<String>();
        isCurrentlyVisible(teamMembers);
        for (WebElement webElement : teamMembers) {
            membersName.add(webElement.getText());
        }
        return membersName;
    }

    public boolean aboutUsHeaderDisplayed() {
        return isAttached(aboutUsPage_Header);
    }

    @Override
    public WebElement getPageID() {
        return aboutUsPage_Header;
    }
}