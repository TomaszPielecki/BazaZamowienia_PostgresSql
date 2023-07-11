package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Update_Table {
    public static void main( String args[] ) {
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
            String sql = "UPDATE klienci set Miasto='Lublin' where id_klient=3;"; //Podmienia miasto z Koscierzyna na Lublin
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM klienci;" );
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
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
