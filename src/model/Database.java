package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final static String DB_HOST = "localhost";
    private final static String DB_NAME = "db_driver";
    private final static String DB_USERNAME = "root"; // ubah di sini
    private final static String DB_PASSWORD = ""; // biarkan kosong kalau tidak ada password

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver: " + e.getMessage());
        }
    }
    
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
        return DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
    }   
}
