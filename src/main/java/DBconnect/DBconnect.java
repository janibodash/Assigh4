package DBconnect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {

    private static final String URL = "jdbc:postgresql://localhost:5433/library";
    private static final String USER = "postgres";
    private static final String PASSWORD = "100";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


