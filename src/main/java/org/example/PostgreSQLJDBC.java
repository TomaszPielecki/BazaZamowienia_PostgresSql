package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");

            String dbUrl = "jdbc:postgresql://localhost:5432/BazaZamowienia";
            String dbUser = "postgres";
            String dbPassword = "Milan123a";

            try (Connection c = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
                System.out.println("Opened database successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
