package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfiguration {

    private static final String URL = "jdbc:mysql://localhost:3306/garage";
    private static final String USER = "root";
    private static final String PASSWORD = "Hello@321";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }


}
