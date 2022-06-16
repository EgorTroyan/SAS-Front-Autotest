package db.entity;

import common.DBConnection;
import org.hibernate.Session;

public class DBToken {
    private final DBConnection connection;

    public DBToken(){
        connection = DBConnection.getConnection();
    }

    public void resetToken(String serial_number){

        Session session = connection.getSession();
        session.beginTransaction();
        String query = "UPDATE las.Tokens SET Token_UserID = 0 WHERE Token_ID = 2)";
        session.createQuery(query);
        session.getTransaction().commit();

    }
}
