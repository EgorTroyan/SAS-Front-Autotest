package db.entity;

import common.DBConnection;
import org.hibernate.Session;

public class DBEnrollment {

    private final DBConnection connection;
    private Enrollment enrollment;

    public DBEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
        connection = DBConnection.getConnection();
    }

    public void resetAttempts(){
        Session session = connection.getSession();
        session.beginTransaction();
        //Enrollment temp = session.get(Enrollment.class, enrollment);
        enrollment.setFailedAttempts(0);
        session.merge(enrollment);
        session.getTransaction().commit();
    }

    public void prepareDB() {
                //try {
            Session session = connection.getSession();
            session.beginTransaction();
            session.persist(enrollment);
            session.getTransaction().commit();
        System.out.println(enrollment);
        //} catch (Exception e){
         //           System.out.println(e);
         //   closeFactory();
       //}
    }

    public void cleanTestDataAfterTests() {
        //try {
            Session session = connection.getSession();
            session.beginTransaction();
        System.out.println(enrollment);
            session.delete(enrollment);
            session.getTransaction().commit();
        //} catch (Exception e) {
         //   closeFactory();
        //}
    }

    public void closeFactory(){
        connection.closeFactory();
    }

}
