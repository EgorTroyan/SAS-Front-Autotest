package pages.enrollment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.List;

public class EnrollmentPage extends BasePage {
    public EnrollmentPage(WebDriver driver) {
        super(driver);
    }

    By text = By.xpath("//div");
    By input = By.xpath(config.getProperty("xpath.first.login_page.input_text"));
    By submit = By.xpath(config.getProperty("xpath.first.login_page.submit"));
    By inputOTP1 = By.xpath(config.getProperty("xpath.first.otp_page.otp1"));
    By inputOTP2 = By.xpath(config.getProperty("xpath.first.otp_page.otp2"));

    public void findData(String whatFind) {
        waitWebElement(driver.findElement(text));
        List<WebElement> divs = driver.findElements(text);
        boolean isCorrect = false;
        for (WebElement e : divs){
            if(e.getText().contains(whatFind)){
               isCorrect = true;
               break;
            }
        }
        Assert.assertTrue(isCorrect
                , "Неудачная проверка на: " + whatFind);
    }

    public void checkPageWithCorrectEnrollment() {
        waitWebElement(driver.findElement(input));
        WebElement div = driver.findElement(input);
        boolean isCorrect = div.isDisplayed();
        Assert.assertTrue(isCorrect
                , "Страница enrollment не загружается с корректной ссылкой");
    }

    public void openPageWithCorrectKey() {
        waitWebElement(driver.findElement(inputOTP1));
        WebElement otp1 = driver.findElement(inputOTP1);
        WebElement otp2 = driver.findElement(inputOTP2);
        boolean isCorrect = otp1.isDisplayed() & otp2.isDisplayed();
        Assert.assertTrue(isCorrect
                , "Страница enrollment не загружается с корректной ссылкой");
    }

    public EnrollmentPage enterKeyNumber(String keyNumber) {
        waitWebElement(driver.findElement(input));
        driver.findElement(input).sendKeys(keyNumber);
        return this;
    }

    public EnrollmentPage clickSubmit() {
        waitWebElement(driver.findElement(submit));
        driver.findElement(submit).click();
        return this;
    }





}
