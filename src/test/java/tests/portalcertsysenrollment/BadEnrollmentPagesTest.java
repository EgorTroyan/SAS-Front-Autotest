package tests.portalcertsysenrollment;


import org.testng.annotations.Test;
import pages.base.BasePage;
import tests.base.BaseTest;

public class BadEnrollmentPagesTest extends BaseTest {

    private final String URL = config.getProperty("text.URL") + expiredEnrollment.getString();
    private final BasePage basePage = new BasePage(driver);



    @Test
    public void checkBadEnrollment(){
        basePage.openURL(URL.substring(0, config.getProperty("text.URL").length() + 7));
        enrollmentPage.openPageWithIncorrectData(config.getProperty("text.incorrect_enrollment.id_not_found"));
    }

    //@Test
    public void checkExpiredEnrollment(){
        basePage.openURL(URL);
        enrollmentPage.openPageWithIncorrectData(config.getProperty("text.incorrect_enrollment.has_expired"));
    }
}
