package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Crate_Table {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BazaZamowienia",
                            "postgres", "Milan123a");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE if not exists Klienci" +
                    "(Id_klient SERIAL PRIMARY KEY NOT NULL," +
                    "Nazwa VARCHAR (100) NOT NULL," +
                    "adres VARCHAR (100) NOT NULL," +
                    "Miasto VARCHAR (100) NOT NULL," +
                    "Wojewodztwo VARCHAR(100) NOT NULL," +
                    "kod VARCHAR(100) NOT NULL," +
                    "Kraj VARCHAR(100) NOT NULL," +
                    "Kontakt_tel VARCHAR(100) NOT NULL," +
                    "email VARCHAR(100) NOT NULL)";
            String sqlZamowienia = "CREATE TABLE if not exists Zamowienia" +
                    "(zam_numer SERIAL PRIMARY KEY NOT NULL," +
                    "zam_data DATE NOT NULL," +
                    "klienci_id INTEGER NOT NULL)";

            String sqlElementyZamowienia = "CREATE TABLE if not exists ElementyZamowienia" +
                    "(\"zam_numer\" SERIAL NOT NULL,\n" +
                    "    \"zam_element\" INTEGER NOT NULL CHECK(\"zam_element\" >= 0),\n" +
                    "    \"prod_id\" VARCHAR (100) NOT NULL,\n" +
                    "    \"ilosc\" INTEGER NOT NULL,\n" +
                    "    \"cena_elem\" NUMERIC (10, 5) NOT NULL)";
            String sqlProdukty = "CREATE TABLE if not exists Produkty" +
                    "(\"prod_id\" SERIAL NOT NULL,\n" +
                    "    \"dost_id\" INTEGER NOT NULL,\n" +
                    "    \"prod_nazwa\" VARCHAR (100) NOT NULL,\n" +
                    "    \"prod_cena\" NUMERIC (10, 5) NOT NULL,\n" +
                    "    \"prod_opis\" VARCHAR (150) NOT NULL)";
            String sqlDostawcy = "CREATE TABLE if not exists Dostawcy" +
                    "(\"dost_id\" SERIAL NOT NULL,\n" +
                    "    \"dost_nazwa\" VARCHAR (100) NOT NULL,\n" +
                    "    \"dost_adres\" VARCHAR (100) NOT NULL,\n" +
                    "    \"dost_miasto\" VARCHAR (100) NOT NULL,\n" +
                    "    \"dost_wojewodztwo\" VARCHAR (100) NOT NULL,\n" +
                    "    \"dost_kod\" VARCHAR (100) NOT NULL,\n" +
                    "    \"dost_kraj\" VARCHAR (100) NOT NULL,\n" +
                    "    \"dost_telefon\" VARCHAR (100) NOT NULL)";

            stmt.executeUpdate(sql);
            stmt.executeUpdate(sqlZamowienia);
            stmt.executeUpdate(sqlElementyZamowienia);
            stmt.executeUpdate(sqlProdukty);
            stmt.executeUpdate(sqlDostawcy);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}

//nowy kod
//import java.sql.Connection;
//        import java.sql.DriverManager;
//        import java.sql.Statement;
//
//public class CreateTable
//    public static void main(String[] args) {
//        String dbUrl = "jdbc:postgresql://localhost:5432/BazaZamowienia";
//        String dbUser = "postgres";
//        String dbPassword = "Milan123a";
//
//        String[] createTableQueries = {
//                "CREATE TABLE IF NOT EXISTS Klienci (" +
//                        "Id_klient SERIAL PRIMARY KEY NOT NULL," +
//                        "Nazwa VARCHAR(100) NOT NULL," +
//                        "adres VARCHAR(100) NOT NULL," +
//                        "Miasto VARCHAR(100) NOT NULL," +
//                        "Wojewodztwo VARCHAR(100) NOT NULL," +
//                        "kod VARCHAR(100) NOT NULL," +
//                        "Kraj VARCHAR(100) NOT NULL," +
//                        "Kontakt_tel VARCHAR(100) NOT NULL," +
//                        "email VARCHAR(100) NOT NULL)",
//                // ... Pozostałe zapytania tworzące tabele ...
//        };
//
//        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
//            connection.setAutoCommit(false);
//            System.out.println("Opened database successfully");
//
//            try (Statement statement = connection.createStatement()) {
//                for (String query : createTableQueries) {
//                    statement.executeUpdate(query);
//                }
//
//                connection.commit();
//                System.out.println("Tables created successfully");
//            }
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        }
//    }
//}
