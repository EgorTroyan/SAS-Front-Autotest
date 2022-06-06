package common;

import config.TestsConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonAction {
    private static WebDriver driver = null;


    private CommonAction() {
    }

    public static WebDriver createDriver() {
        if (driver == null) {
            TestsConfig config = TestsConfig.getConfig();
            System.setProperty(config.getProperty("webdriver.chromedriver.name")
                    , config.getProperty("webdriver.chromedriver.path"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("wait.implicit"))
                    , TimeUnit.SECONDS);
        }
        return driver;
    }


}
