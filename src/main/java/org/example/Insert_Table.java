package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert_Table {
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
//          String sql = "INSERT INTO if not exist Klienci (Id_klient,Nazwa,adres,Miasto,Wojewodztwo,kod,Kraj,Kontakt_tel,email) "
//                    + "VALUES (1, 'Sobisz','Grunwaldzka', 'Gdansk', 'Pomorskie', '83-300','Polska','720-222-222','Sobisz@o2.pl' );";
//          stmt.executeUpdate(sql);

//            String sqlDost1 = "INSERT INTO Klienci (Id_klient,Nazwa,adres,Miasto,Wojewodztwo,kod,Kraj,Kontakt_tel,email) "
//                    + "VALUES (4, 'GS21','Ceynowy', 'Egiertowo', 'Pomorskie', '83-320','Polska','720-255-222','CeyGS@o2.pl' );";
//            stmt.executeUpdate(sqlDost1);
//            String sql = "INSERT INTO Klienci (Id_klient,Nazwa,adres,Miasto,Wojewodztwo,kod,Kraj,Kontakt_tel,email) "
//                    + "VALUES (5, 'Ciesielska','Starowiejska', 'Somonino', 'Pomorskie', '83-300','Polska','720-223-222','Cie@o2.pl' );";
//            stmt.executeUpdate(sql);
//            String sqlDost2 = "INSERT INTO Klienci (Id_klient,Nazwa,adres,Miasto,Wojewodztwo,kod,Kraj,Kontakt_tel,email) "
//                    + "VALUES (2, 'Sablewska','Kreta', 'Koscierzyna', 'Pomorskie', '82-660','Polska','720-255-222','Sab55@go2.pl' );";
//            stmt.executeUpdate(sqlDost2);
//            String sqlDost3 = "INSERT INTO Klienci (Id_klient,Nazwa,adres,Miasto,Wojewodztwo,kod,Kraj,Kontakt_tel,email) "
//                    + "VALUES (3, 'Kowalska','Cicha', 'Koscierzyna', 'Pomorskie', '82-660','Polska','720-223-552','Kowal@go2.pl' );";
//            stmt.executeUpdate(sqlDost3);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}
