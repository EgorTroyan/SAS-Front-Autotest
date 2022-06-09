package tests.portalcertsysenrollment;


import org.testng.annotations.Test;
import tests.base.BaseTest;

public class BadEnrollmentPagesTest extends BaseTest {

    private final String URL = config.getProperty("text.URL") + enrollment.getString();

    @Test
    public void checkBadEnrollment(){
        basePage.openURL(URL.substring(0, config.getProperty("text.URL").length() + 7));
        enrollmentPage.openPageWithIncorrectData(config.getProperty("text.incorrect_enrollment.id_not_found"));
    }
}
