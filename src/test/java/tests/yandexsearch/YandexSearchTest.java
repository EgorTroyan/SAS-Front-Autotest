package tests.yandexsearch;

import common.EnrollmentString;
import db.entity.DBEnrollment;
import db.entity.Enrollment;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.time.LocalDateTime;

public class YandexSearchTest extends BaseTest {
    protected LocalDateTime currentDate = LocalDateTime.now();
    protected LocalDateTime stopDate = currentDate.plusDays(3);
    protected Enrollment enrollment = new Enrollment(
            new EnrollmentString().generateEnrollmentString(32)
            , 6, 1, 1, currentDate, stopDate, 6);
    protected DBEnrollment dbEnrollment = new DBEnrollment(enrollment);

    @Test
    public void test1() {
       dbEnrollment.prepareDB();
       //dbEnrollment.closeFactory();
    }

    @Test
    public void test2() {
        dbEnrollment.cleanTestDataAfterTests();
        dbEnrollment.closeFactory();

    }
}
