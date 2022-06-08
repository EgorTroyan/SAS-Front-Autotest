package pages.enrollment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;

public class FirstPage extends BasePage {
    public FirstPage(WebDriver driver) {
        super(driver);
    }

    By text = By.xpath("//div");
    By input = By.xpath(config.getProperty("xpath.first.login_page.input_text"));
    By submit = By.xpath(config.getProperty("xpath.first.login_page.submit"));

    public FirstPage openFirstPageWithIncorrectEnrollment() {
        List<WebElement> divs = driver.findElements(text);
        for (WebElement e : divs){
            if(e.getText().contains(config.getProperty("")))
            e.getText()
        }
        driver.findElement(submit).click();
        return this;
    }
}
