
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Insert_Table {
    public static void main(String[] args) {
        String dbUrl = "jdbc:postgresql://localhost:5432/BazaZamowienia";
        String dbUser = "postgres";
        String dbPassword = "Milan123a";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            try (Statement statement = connection.createStatement()) {
                String[] sqlInserts = {
                        // Wstawianie danych do tabeli Klienci
                        "INSERT INTO Klienci (Id_klient, Nazwa, adres, Miasto, Wojewodztwo, kod, Kraj, Kontakt_tel, email) "
                                + "VALUES (1, 'Sobisz', 'Grunwaldzka', 'Gdańsk', 'Pomorskie', '83-300', 'Polska', '720-222-222', 'Sobisz@o2.pl')",
                        "INSERT INTO Klienci (Id_klient, Nazwa, adres, Miasto, Wojewodztwo, kod, Kraj, Kontakt_tel, email) "
                                + "VALUES (2, 'GS21', 'Ceynowy', 'Egiertowo', 'Pomorskie', '83-320', 'Polska', '720-255-222', 'CeyGS@o2.pl')",
                        "INSERT INTO Klienci (Id_klient, Nazwa, adres, Miasto, Wojewodztwo, kod, Kraj, Kontakt_tel, email) "
                                + "VALUES (3, 'Ciesielska', 'Starowiejska', 'Somonino', 'Pomorskie', '83-300', 'Polska', '720-223-222', 'Cie@o2.pl')",
                        "INSERT INTO Klienci (Id_klient, Nazwa, adres, Miasto, Wojewodztwo, kod, Kraj, Kontakt_tel, email) "
                                + "VALUES (4, 'Sablewska', 'Kreta', 'Koscierzyna', 'Pomorskie', '82-660', 'Polska', '720-255-222', 'Sab55@go2.pl')",
                        "INSERT INTO Klienci (Id_klient, Nazwa, adres, Miasto, Wojewodztwo, kod, Kraj, Kontakt_tel, email) "
                                + "VALUES (5, 'Kowalska', 'Cicha', 'Koscierzyna', 'Pomorskie', '82-660', 'Polska', '720-223-552', 'Kowal@go2.pl')"
                };

                for (String sql : sqlInserts) {
                    try {
                        statement.executeUpdate(sql);
                    } catch (SQLException e) {
                        // Przechwytuj wyjątek, ale nie rób niczego w przypadku duplikatu
                        if (e.getMessage().contains("duplicate key value")) {
                            System.out.println("Row already exists: " + sql);
                        } else {
                            System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        }
                    }
                }

                connection.commit();
                System.out.println("Records created successfully");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
