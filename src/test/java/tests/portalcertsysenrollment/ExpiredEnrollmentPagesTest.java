package tests.portalcertsysenrollment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ExpiredEnrollmentPagesTest extends BaseTest {

    private final String URL = config.getProperty("text.URL") + expiredEnrollment.getString();

    @Test
    public void checkBadEnrollment(){
        basePage.openURL(URL);

        enrollmentPage.openPageWithIncorrectData(config.getProperty("text.incorrect_enrollment.has_expired"));
    }
}
