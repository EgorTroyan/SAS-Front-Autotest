package tests.base;

import common.CommonAction;
import common.EnrollmentString;
import config.TestsConfig;
import db.entity.DBEnrollment;
import db.entity.Enrollment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.base.BasePage;
import pages.enrollment.EnrollmentPage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    //protected BasePage basePage = new BasePage(driver);
    protected EnrollmentPage enrollmentPage = new EnrollmentPage(driver);
    protected TestsConfig config = TestsConfig.getConfig();


    protected LocalDateTime currentDate = LocalDateTime.now();
    protected LocalDateTime stopDate = currentDate.plusDays(3);
    protected Enrollment enrollment = new Enrollment(
            new EnrollmentString().generateEnrollmentString(32)
            , 6, 1, 1, currentDate, stopDate, 6);
    protected Enrollment expiredEnrollment = new Enrollment(
            new EnrollmentString().generateEnrollmentString(32)
            , 6, 1, 1, currentDate.minusDays(5), stopDate.minusDays(5), 6);
    protected Enrollment enrollmentForKeys = new Enrollment(
            new EnrollmentString().generateEnrollmentString(32)
            , 6, 1, 1, currentDate, stopDate, 6);
    protected DBEnrollment dbEnrollment = new DBEnrollment(enrollment);
    protected DBEnrollment dbExEnrollment = new DBEnrollment(expiredEnrollment);
    protected DBEnrollment dbKeyEnrollment = new DBEnrollment(enrollmentForKeys);

    @BeforeSuite
    public void beforeStart() {
        dbEnrollment.prepareDB();
        dbExEnrollment.prepareDB();
        dbKeyEnrollment.prepareDB();
    }

    @AfterTest
    public void close(){
        driver.close();
    }

    @AfterSuite(alwaysRun = true)
    public void quit() {
        driver.quit();
    }

    @AfterSuite
    public void afterTests() {
        dbEnrollment.cleanTestDataAfterTests();
        dbExEnrollment.cleanTestDataAfterTests();
        dbKeyEnrollment.cleanTestDataAfterTests();
        dbEnrollment.closeFactory();
        dbExEnrollment.closeFactory();
        dbKeyEnrollment.closeFactory();
    }
}
