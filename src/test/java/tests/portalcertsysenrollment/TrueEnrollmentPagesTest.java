package tests.portalcertsysenrollment;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class TrueEnrollmentPagesTest extends BaseTest {

    private final String URL = config.getProperty("text.URL") + enrollment.getString();

    @Test
    public void checkTrueEnrollment(){
        basePage.openURL(URL);
        enrollmentPage.openPageWithCorrectEnrollment();
    }

    @Test
    public void checkIncorrectKeyNameFirstKirrilica(){
        //basePage.openURL(URL);
        enrollmentPage
                //.openPageWithCorrectEnrollment()
                .enterKeyNumber("абвгд")
                .clickSubmit()
                .openPageWithIncorrectData(config.getProperty("text.incorrect_key_number"));
    }
    @Test
    public void checkIncorrectKeyNameSecond(){
        //basePage.openURL(URL);
        enrollmentPage
               // .openPageWithCorrectEnrollment()
                .enterKeyNumber("AS000000")
                .clickSubmit()
                .openPageWithIncorrectData(config.getProperty("text.incorrect_key_number"));
    }
    @Test
    public void checkIncorrectKeyNameThird(){
        //basePage.openURL(URL);
        enrollmentPage
               // .openPageWithCorrectEnrollment()
                .enterKeyNumber("AS000")
                .clickSubmit()
                .openPageWithIncorrectData(config.getProperty("text.incorrect_key_number.too_many_times"));
    }




}
