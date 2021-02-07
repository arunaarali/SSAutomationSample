package test_utils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public enum WebDriverType {
    CHROME("webdriver.chrome.driver", "/usr/local/bin/chromedriver"),
    FIREFOX("webdriver.gecko.driver", "/usr/local/bin/geckodriver"),
    EDGE("", "");//Example

    public String getDriverSystemProperty;
    public String driverPath;
}
