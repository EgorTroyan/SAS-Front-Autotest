package tests.portalcertsysenrollment;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.base.BasePage;
import tests.base.BaseTest;

import java.time.Duration;

public class TrueEnrollmentPagesTest extends BaseTest {

    private final String URL = config.getProperty("text.URL") + enrollment.getString();
    private final BasePage basePage = new BasePage(driver);


    public void checkKeyName(String key, String whatFind){
        enrollmentPage
                .enterKeyNumber(key)
                .clickSubmit()
                .openPageWithIncorrectData(whatFind);
    }

    public void restoreAttempts(){
       dbEnrollment.resetAttempts();
    }

    @Test
    public void checkTrueEnrollment(){
        basePage.openURL(URL);
        enrollmentPage.openPageWithCorrectEnrollment();
    }

    @Test (dependsOnMethods = {"checkTrueEnrollment"})
    public void checkIncorrectKeyNameThreeTimes(){
        int count = 0;
        String[] keys = new String[]{"авпыврек", "AS000000", "as000"};
        while (true){
            if(count < 2) {
                checkKeyName(keys[count], config.getProperty("text.incorrect_key_number"));
            } else {
                checkKeyName(keys[count], config.getProperty("text.incorrect_key_number.too_many_times"));
                break;
            }
            count++;
        }
    }

    @Test (dependsOnMethods = {"checkIncorrectKeyNameThreeTimes"})
    public void checkIncorrectKeyNameThreeTimesThreeTimes(){
        int count = 0;
        while (count < 2){
            checkTrueEnrollment();
            checkIncorrectKeyNameThreeTimes();
            count++;
        }
        basePage.openURL(URL);
        enrollmentPage.openPageWithIncorrectData(config.getProperty("text.incorrect_enrollment.to_many_failed_attempts"));
    }





}
