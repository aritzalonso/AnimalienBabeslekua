
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {

    private static final String URL = "jdbc:mysql://localhost:3306/babeslekua_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234"; // XAMPP-en hutsik egon ohi da

    public static Connection lortuKonexioa() throws SQLException {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ez da MySQL driver-a aurkitu: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}