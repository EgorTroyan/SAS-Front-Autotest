package pages.base;

import config.TestsConfig;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    protected TestsConfig config = TestsConfig.getConfig();

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String url) {
        driver.get(url);
    }
}
