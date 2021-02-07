package stoic_studio.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stoic_studio.PageObject;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends PageObject {

    @FindBy(xpath = "//title")
    WebElement homepage_Title;
    @FindBy(id = "mce-EMAIL")
    WebElement enterEmailID_textBox;
    @FindBy(id = "mc-embedded-subscribe")
    WebElement subscriber_Button;
    @FindBy(id = "our_games_header")
    WebElement gameSection_Header;
    @FindBy(xpath = "//div[@class='games1']/div[contains(normalize-space(@class),\"one_third\")]")
    List<WebElement> displayed_Games;
    @FindBy(xpath = "(//ul[@id='nav'])[last()]")
    List<WebElement> navbar_items;
    @FindBy(xpath = "(//a[contains(text(),\"ABOUT US\")])[1]")
    WebElement aboutUsNavbar;

    public HomePageObject(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getPageTitle() {
        isCurrentlyVisible(homepage_Title);
        return homepage_Title.getText();
    }

    public void enterEmailID(String emailID) {
        isCurrentlyVisible(enterEmailID_textBox);
        enterEmailID_textBox.clear();
        enterEmailID_textBox.sendKeys(emailID);
    }

    public void clickSubscribeButton() {
        isCurrentlyVisible(subscriber_Button);
        subscriber_Button.click();
    }

    public boolean verifyTheExistenceOfGameSectionHeader() {
        return isCurrentlyVisible(gameSection_Header);
    }

    public boolean verifyTheNumberOfDisplayedGames(int expectedGameCount) {
        isCurrentlyVisible(displayed_Games);
        return displayed_Games.size() == expectedGameCount;
    }

    public List<String> getNavbarText() {
        isCurrentlyVisible(navbar_items);
        List<String> navbarText = new ArrayList<String>();
        for (WebElement webElement : navbar_items) {
            navbarText.add(webElement.getText());
        }
        return navbarText;
    }

    public void navigateTo(String navigationItem){
        isCurrentlyVisible(navbar_items);
        for (WebElement webElement: navbar_items){
            if(webElement.getText().equals(navigationItem)){
                webElement.click();
                break;
            }
        }
    }

    @Override
    public WebElement getPageID(){
        return enterEmailID_textBox;
    }

}
