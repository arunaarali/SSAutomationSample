package stoic_studio;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public abstract class PageObject {

    @Getter
    protected WebDriver webDriver;
    @Getter
    protected WebDriver wait;
    @Getter
    protected int waitTimeInSeconds = 30;

    public PageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = (WebDriver) new WebDriverWait(webDriver, waitTimeInSeconds);
    }

    /**
     * Boolean method verifies the existence of WebElement.
     *
     * @param webElement webElement
     * @return true = if element is visible, false = if element is not visible.
     */
    public boolean isCurrentlyVisible(WebElement webElement) {
        return isAttached(webElement);
    }

    /**
     * Boolean method verifies the existence of WebElement.
     *
     * @param webElement webElement
     * @return true = if element is visible, false = if element is not visible.
     */
    protected boolean isAttached(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            return false;
        }
    }

    /**
     * Boolean method verifies the existence of WebElement.By.
     *
     * @param By it can be xpath, accessibility id, css, classname etc...
     * @return true = if element is visible, false = if element is not visible.
     */
    protected boolean isAttached(By by) {
        try {
            return webDriver.findElements(by).size() > 0;
        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            return false;
        }
    }

}
