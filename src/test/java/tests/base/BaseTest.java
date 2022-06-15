package tests.base;

import common.CommonAction;
import config.TestsConfig;
import db.entity.DBEnrollment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.enrollment.EnrollmentPage;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected EnrollmentPage enrollmentPage = new EnrollmentPage(driver);
    protected TestsConfig config = TestsConfig.getConfig();
    protected DBEnrollment dbEnrollment = DBEnrollment.getDBEnrollment();

    @BeforeSuite
    public void beforeStart() {
        dbEnrollment.prepareDB();
    }

    @AfterSuite
    public void afterTests() {
        dbEnrollment.cleanTestDataAfterTests();
        dbEnrollment.closeFactory();
        driver.quit();
    }
}
