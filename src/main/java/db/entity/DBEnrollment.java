package db.entity;

import common.DBConnection;
import common.EnrollmentString;
import org.hibernate.Session;

import java.time.LocalDateTime;

public class DBEnrollment {

    private static DBEnrollment dbEnrollment;
    private final DBConnection connection;
    private final Enrollment enrollment;
    private final Enrollment expEnrollment;
    private final Enrollment forKeyEnrollment;


    private DBEnrollment() {
        enrollment = new Enrollment(
                new EnrollmentString().generateEnrollmentString(32)
                , 6, 1, 1, LocalDateTime.now(), LocalDateTime.now().plusDays(3), 6);
        expEnrollment = new Enrollment(
                new EnrollmentString().generateEnrollmentString(32)
                , 6, 1, 1, LocalDateTime.now().minusDays(5), LocalDateTime.now().minusDays(2), 6);
        forKeyEnrollment = new Enrollment(
                new EnrollmentString().generateEnrollmentString(32)
                , 6, 1, 1, LocalDateTime.now(), LocalDateTime.now().plusDays(3), 6);
        connection = DBConnection.getConnection();
    }

    public static DBEnrollment getDBEnrollment(){
        if(dbEnrollment == null) {
            dbEnrollment = new DBEnrollment();
        }
        return dbEnrollment;
    }

    public Enrollment getTrueEnrollment() {
        return enrollment;
    }

    public Enrollment getExpEnrollment() {
        return expEnrollment;
    }

    public Enrollment getForKeyEnrollment() {
        return forKeyEnrollment;
    }

    public void prepareDB() {
        Session session = connection.getSession();
        session.beginTransaction();
        session.persist(enrollment);
        session.persist(expEnrollment);
        session.persist(forKeyEnrollment);
        session.getTransaction().commit();
    }

    public void cleanTestDataAfterTests() {

        Session session = connection.getSession();
        session.beginTransaction();
        session.remove(enrollment);
        session.remove(expEnrollment);
        session.remove(forKeyEnrollment);
        session.getTransaction().commit();
    }

    public void closeFactory(){
        connection.closeFactory();
    }

}
