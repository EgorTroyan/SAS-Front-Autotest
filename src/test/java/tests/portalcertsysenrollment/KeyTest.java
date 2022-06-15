package tests.portalcertsysenrollment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class KeyTest extends BaseTest {

    private final String URL = config.getProperty("text.URL") + dbEnrollment.getForKeyEnrollment().getString();

    @Test
    public void checkCorrectKeyEnrollment(){
        //dbEnrollment.resetAttempts();
        enrollmentPage.openURL(URL);
        enrollmentPage
                .enterKeyNumber(config.getProperty("test_key.number"))
                .clickSubmit()
                .openPageWithCorrectKey();
    }
}
