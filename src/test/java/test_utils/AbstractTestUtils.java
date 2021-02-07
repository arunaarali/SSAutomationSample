package test_utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import stoic_studio.PageObject;
import stoic_studio.pageobject_utils.WaitUtility;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public abstract class AbstractTestUtils {

    /**
     * Method to intiate the required WebDriver based on the test setup.
     *
     * @param driverType Expected DriverType these can be CHROME, FIREFOX or IE.
     * @return
     */
    public static WebDriver initWebDriver(WebDriverType driverType) {
        System.setProperty(driverType.getDriverSystemProperty, driverType.driverPath);
        switch (driverType) {
            case FIREFOX:
                return new FirefoxDriver();
            case EDGE:
                return new EdgeDriver();
            case CHROME:
            default:
                return new ChromeDriver();
        }
    }

    public boolean pageCurrentlyVisible(final WebDriver webDriver, final PageObject pageObject,
                                        final int waitTimeInSeconds) {
        String pageName = pageObject.getClass().getSimpleName();
        AtomicInteger attempt = new AtomicInteger();
        log.info("Checking visibility of Page object <{}>.", pageName);
        return WaitUtility.waitUntil(() -> {
            if (pageObject.isPageVisible()) {
                log.info("Expected page {} is currently visible.",
                        pageName);
                return true;
            } else {
                log.info("Expected page <{}> is currently not visible with the attempt# <{}> ",
                        pageName, attempt.incrementAndGet());
                return false;
            }
        }, waitTimeInSeconds);
    }

}
