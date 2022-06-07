package db.entity;

import common.DBConnection;
import org.hibernate.Session;

public class DBEnrollment {
    private final Session session;
    private final DBConnection connection;
    private Enrollment enrollment;

    public DBEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
        connection = new DBConnection();
        session = connection.getSession();
    }

    public void prepareDB() {
                try {
            session.beginTransaction();
            session.persist(enrollment);
            session.getTransaction().commit();
        } catch (Exception e){
            closeFactory();
        }
    }

    public void cleanTestDataAfterTests() {
        try {
            session.beginTransaction();
            session.detach(enrollment);
            session.getTransaction().commit();
        } catch (Exception e) {
            closeFactory();
        }
    }

    public void closeFactory(){
        connection.closeFactory();
    }

}
