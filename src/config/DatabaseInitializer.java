package config;

import util.DBConnection;

public class DatabaseInitializer {

    public static void init() {
        try {
            DBConnection.getConnection();
            System.out.println("Database Initialized Successfully");
        } catch (Exception e) {
            System.out.println("Database Initialization Failed");
            e.printStackTrace();
        }
    }
}