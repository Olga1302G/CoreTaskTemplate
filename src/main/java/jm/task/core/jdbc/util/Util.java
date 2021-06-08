package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    //private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12345root-";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
    // реализуйте настройку соеденения с БД
}
