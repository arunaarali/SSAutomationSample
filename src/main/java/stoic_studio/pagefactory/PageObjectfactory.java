package stoic_studio.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stoic_studio.PageObject;
import stoic_studio.pageobjects.AboutUsPageObject;
import stoic_studio.pageobjects.HomePageObject;

/**
 * Page factory design pattern to maintain Object creation from single class.
 */
public class PageObjectfactory extends PageObject {

    public PageObjectfactory(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public WebElement getPageID() {
        return null;
    }

    /**
     * Method returns the About us page object.
     * @param driver can be any supported browser.
     * @return AboutUsPageObject.
     */
    public static AboutUsPageObject createAboutUsPageObject(WebDriver driver){
        return new AboutUsPageObject(driver);
    }

    /**
     * Method to return HomePage object.
     * @param driver can be any supported browser.
     * @return eAboutUsPagObject.
     */
    public static HomePageObject createHomePageObject(WebDriver driver){
        return new HomePageObject(driver);
    }
}
