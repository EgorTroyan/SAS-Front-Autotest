package tests.portalcertsysenrollment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class KeyTest extends BaseTest {

    private final String URL = config.getProperty("text.URL") + enrollmentForKeys.getString();

    //@Test
    public void checkCorrectKeyEnrollment(){
        //dbEnrollment.resetAttempts();
        //basePage.openURL(URL);
        enrollmentPage
                .enterKeyNumber(config.getProperty("test_key.number"))
                .clickSubmit()
                .openPageWithCorrectKey();
    }
}
