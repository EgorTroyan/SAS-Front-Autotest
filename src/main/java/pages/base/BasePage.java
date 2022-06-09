package pages.base;

import config.TestsConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BasePage {
    protected WebDriver driver;

    protected TestsConfig config = TestsConfig.getConfig();

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public WebElement waitWebElement(WebElement element){
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
