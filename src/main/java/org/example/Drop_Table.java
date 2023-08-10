package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Stary Kod
//    public static void main(String args[]) {
//        Connection c = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/BazaZamowienia",
//                            "postgres", "Milan123a");
//            System.out.println("Opened database successfully");
//
//            stmt = c.createStatement();
//            String sql = "DELETE from Klienci where id_klient = 3;";//usowanie wiersza w kolumnie Klienci
//            stmt.executeUpdate(sql);
//
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Klienci;");
//            while (rs.next()) {
//                int id = rs.getInt("id_klient");
//                String name = rs.getString("nazwa");
//                String address = rs.getString("adres");
//                String miasto = rs.getString("miasto");
//                String wojewodztwo = rs.getString("wojewodztwo");
//                String kod = rs.getString("kod");
//                String kraj = rs.getString("kraj");
//                String kontakt_tel = rs.getString("kontakt_tel");
//                String email = rs.getString("email");
//                System.out.println("ID = " + id);
//                System.out.println("NAME = " + name);
//                System.out.println("KRAJ = " + kraj);
//                System.out.println("MIASTO = " + miasto);
//                System.out.println("WOJEWODZTWO = " + wojewodztwo);
//                System.out.println("KOD = " + kod);
//                System.out.println("ADDRESS = " + address);
//                System.out.println("KONTAKT_TEL = " + kontakt_tel);
//                System.out.println("EMAIL = " + email);
//                System.out.println();
//            }
//            rs.close();
//            stmt.close();
//            c.close();
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Operation done successfully");
//    }

//Nowy Kod
public class Drop_Table {
    public static void main(String[] args) {
        String dbUrl = "jdbc:postgresql://localhost:5432/BazaZamowienia";
        String dbUser = "postgres";
        String dbPassword = "Milan123a";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            System.out.println("Opened database successfully");

            try (Statement statement = connection.createStatement()) {
                // Usuwanie rekordu z tabeli Klienci
                int deletedRowCount = statement.executeUpdate("DELETE FROM Klienci WHERE id_klient = 3;");
                System.out.println("Deleted " + deletedRowCount + " row(s) from Klienci");

                // Wyświetlanie pozostałych rekordów w tabeli Klienci
                try (ResultSet rs = statement.executeQuery("SELECT * FROM Klienci;")) {
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
                }

                System.out.println("Operation done successfully");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}

