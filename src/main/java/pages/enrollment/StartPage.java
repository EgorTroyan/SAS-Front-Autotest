package pages.enrollment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    By input = By.xpath("//input[@name='text']");
    By submit = By.xpath("//button[@type='submit']");

    public StartPage findYandex() {
        driver.findElement(input).sendKeys("Yandex");
        driver.findElement(submit).click();
        return this;
    }
}
