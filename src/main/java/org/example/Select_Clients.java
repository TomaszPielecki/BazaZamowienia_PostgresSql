package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_Clients {
    public static void main(String[] args) {
        String dbUrl = "jdbc:postgresql://localhost:5432/BazaZamowienia";
        String dbUser = "postgres";
        String dbPassword = "Milan123a";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            System.out.println("Connected to the database");

            String selectQuery = "SELECT * FROM Klienci";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id_klient");
                    String name = resultSet.getString("nazwa");
                    String address = resultSet.getString("adres");
                    String miasto = resultSet.getString("miasto");
                    String wojewodztwo = resultSet.getString("wojewodztwo");
                    String kod = resultSet.getString("kod");
                    String kraj = resultSet.getString("kraj");
                    String kontaktTel = resultSet.getString("kontakt_tel");
                    String email = resultSet.getString("email");

                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Address: " + address);
                    System.out.println("City: " + miasto);
                    System.out.println("State: " + wojewodztwo);
                    System.out.println("Postal Code: " + kod);
                    System.out.println("Country: " + kraj);
                    System.out.println("Contact Tel: " + kontaktTel);
                    System.out.println("Email: " + email);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
