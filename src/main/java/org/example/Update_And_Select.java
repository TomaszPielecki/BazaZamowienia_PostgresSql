package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_And_Select {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/BazaZamowienia";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Milan123a";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            updateCity(3, "Lublin");
            selectClients();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    private static void updateCity(int clientId, String newCity) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = connection.createStatement()) {

            String updateSql = "UPDATE Klienci SET Miasto = '" + newCity + "' WHERE id_klient = " + clientId;
            int rowsAffected = stmt.executeUpdate(updateSql);
            connection.commit();

            System.out.println("Rows updated (City): " + rowsAffected);
        }
    }

    private static void selectClients() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM Klienci;");
            while (rs.next()) {
                int id = rs.getInt("id_klient");
                String name = rs.getString("nazwa");
                String address = rs.getString("adres");
                String miasto = rs.getString("miasto");
                String wojewodztwo = rs.getString("wojewodztwo");
                String kod = rs.getString("kod");
                String kraj = rs.getString("kraj");
                String kontakt_tel = rs.getString("kontakt_tel");
                String email = rs.getString("email");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("KRAJ = " + kraj);
                System.out.println("MIASTO = " + miasto);
                System.out.println("WOJEWODZTWO = " + wojewodztwo);
                System.out.println("KOD = " + kod);
                System.out.println("ADDRESS = " + address);
                System.out.println("KONTAKT_TEL = " + kontakt_tel);
                System.out.println("EMAIL = " + email);
                System.out.println();
            }
            rs.close();
        }
    }
}
