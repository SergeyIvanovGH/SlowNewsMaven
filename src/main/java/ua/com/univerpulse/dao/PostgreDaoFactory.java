package ua.com.univerpulse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgreDaoFactory {
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";
    private final String URL = "jdbc:postgresql://127.0.0.1:5432/svivanov";
    private final String DRIVER = "org.postgresql.Driver";

    public Connection getConnection() throws PersistException {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new PersistException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
