package tests.base;

import common.CommonAction;
import common.EnrollmentString;
import db.entity.DBEnrollment;
import db.entity.Enrollment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.base.BasePage;
import pages.enrollment.FirstPage;

import java.time.LocalDateTime;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected FirstPage firstPage = new FirstPage(driver);

    protected LocalDateTime currentDate = LocalDateTime.now();
    protected LocalDateTime stopDate = currentDate.plusDays(3);
    protected Enrollment enrollment = new Enrollment(
            new EnrollmentString().generateEnrollmentString(32)
            , 6, 1, 1, currentDate, stopDate, 6);
    protected DBEnrollment dbEnrollment = new DBEnrollment(enrollment);

    @BeforeSuite
    public void beforeStart() {
        dbEnrollment.prepareDB();
    }

    @AfterSuite
    public void afterTests() {
        dbEnrollment.cleanTestDataAfterTests();
    }
}
