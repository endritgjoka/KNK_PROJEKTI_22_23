package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;


    public static Connection getConnection() throws SQLException{
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/menaxhimi_i_fluturimeve_airoport";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
