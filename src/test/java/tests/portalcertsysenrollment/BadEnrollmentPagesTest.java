package tests.portalcertsysenrollment;


import org.testng.annotations.Test;
import tests.base.BaseTest;

public class BadEnrollmentPagesTest extends BaseTest {
    private final String URL = config.getProperty("text.URL") + dbEnrollment.getExpEnrollment().getString();



    @Test
    public void checkBadEnrollment(){
        System.out.println("BadEnrollmentPagesTest:\n" + dbEnrollment.getExpEnrollment());
        System.out.println("BadEnrollmentPagesTest URL:\n" + URL);
        enrollmentPage.openURL(URL.substring(0, config.getProperty("text.URL").length() + 7));
        enrollmentPage.findData(config.getProperty("text.incorrect_enrollment.id_not_found"));
    }

    @Test
    public void checkExpiredEnrollment(){
        System.out.println("ExpiredEnrollmentPagesTest:\n" + dbEnrollment.getExpEnrollment());
        System.out.println("ExpiredEnrollmentPagesTest URL:\n" + URL);
        enrollmentPage.openURL(URL);
        enrollmentPage.findData(config.getProperty("text.incorrect_enrollment.has_expired"));
    }
}
