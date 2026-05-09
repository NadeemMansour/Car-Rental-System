package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/car_rental_system";

    private static final String USER = "root";

    private static final String PASSWORD = "1234";

    private static Connection connection;

    // Prevent object creation
    private DBConnection() {
    }

    public static Connection getConnection() {

        try {

            // Check if connection is closed or null
            if (connection == null || connection.isClosed()) {

                // Load MySQL Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create Connection
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );

                System.out.println("Database Connected Successfully!");
            }

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL Driver Not Found!");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return connection;
    }

    // Test Connection
    public static void main(String[] args) {

        getConnection();
    }
}