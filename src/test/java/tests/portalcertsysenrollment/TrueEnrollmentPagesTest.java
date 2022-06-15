package tests.portalcertsysenrollment;


import org.testng.annotations.Test;
import tests.base.BaseTest;

public class TrueEnrollmentPagesTest extends BaseTest {

    private final String URL = config.getProperty("text.URL") + dbEnrollment.getTrueEnrollment().getString();


    public void checkKeyName(String key, String whatFind){
        enrollmentPage
                .enterKeyNumber(key)
                .clickSubmit()
                .findData(whatFind);
    }

    @Test
    public void checkTrueEnrollment(){
        enrollmentPage.openURL(URL);
        enrollmentPage.checkPageWithCorrectEnrollment();
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
        enrollmentPage.openURL(URL);
        enrollmentPage.findData(config.getProperty("text.incorrect_enrollment.to_many_failed_attempts"));
    }





}
