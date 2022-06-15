package common;

import config.TestsConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CommonAction {
    private static WebDriver driver = null;


    private CommonAction() {
    }

    public static WebDriver createDriver() {
        if (driver == null) {
            try {
                TestsConfig config = TestsConfig.getConfig();
                System.setProperty(config.getProperty("webdriver.chromedriver.name")
                        , config.getProperty("webdriver.chromedriver.path"));
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("wait.implicit"))));
            } catch (Exception e) {
                Assert.fail("Проблемы с вебдрайвером");
            }
        }
        return driver;
    }

}
