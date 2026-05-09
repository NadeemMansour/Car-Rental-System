import util.DBConnection;

public class TestDB {
   public TestDB() {
   }

   public static void main(String[] var0) {
      DBConnection.getConnection();
   }
}

// import java.sql.Connection;
// import java.sql.DriverManager;

// public class DBConnection {

//     private static final String URL =
//             "jdbc:mysql://localhost:3306/car_rental_system";

//     private static final String USER = "root";

//     private static final String PASSWORD = "1234";

//     public static Connection getConnection() {

//         try {

//             Connection con =
//                     DriverManager.getConnection(URL, USER, PASSWORD);

//             System.out.println("Database Connected!");

//             return con;

//         } catch (Exception e) {

//             System.out.println("Connection Failed!");

//             e.printStackTrace();

//             return null;
//         }
//     }

//     public static void main(String[] args) {

//         getConnection();

//     }
// }