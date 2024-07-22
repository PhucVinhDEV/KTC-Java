package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Utils.OracleUtil.*;

public class JDBCHelper {


    private Connection connection;

    public JDBCHelper() {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Oracle JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            // Create a connection to the database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to Oracle Database!");
        } catch (SQLException e) {
            System.out.println("Error: Connection failed.");
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from Oracle Database.");
            }
        } catch (SQLException e) {
            System.out.println("Error: Failed to close connection.");
            e.printStackTrace();
        }
    }

    // Other database operations can be added here, such as executeQuery, executeUpdate, etc.
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
