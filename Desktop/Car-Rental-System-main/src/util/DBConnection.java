
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // =========================
    // DATABASE INFORMATION
    // =========================
    private static final String URL =
            "jdbc:mysql://localhost:3306/carrentalsystem";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "";

    // =========================
    // GET CONNECTION
    // =========================
    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Database Connected Successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver Not Found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return connection;
    }
}
// package util;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class DBConnection {

//     private static final String URL ="jdbc:mysql://localhost:3306/CarRentalSystem?useSSL=false&serverTimezone=UTC";
//     private static final String USER = "root";
//     private static final String PASSWORD = "";
//     private static Connection connection;

//     private DBConnection() {
//     }
//     public static Connection getConnection() {
//         try {
//             if (connection == null || connection.isClosed()) {

//                 Class.forName("com.mysql.cj.jdbc.Driver");

//                 connection = DriverManager.getConnection(URL,USER,PASSWORD);

//                 System.out.println("Database Connected Successfully!");

//             }

//         } catch (ClassNotFoundException e) {
//             System.out.println("MySQL Driver Not Found!");
//             e.printStackTrace();

//         } catch (SQLException e) {
//             System.out.println("Database Connection Failed!");
//             e.printStackTrace();
//         }
//         return connection;
//     }
// }