package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Alter_Table {
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
//            String sqlAlter = "ALTER TABLE IF NOT EXISTS public.zamowienia\n" +
//                    "ADD CONSTRAINT constraint_fk\n" +
//                    "FOREIGN KEY (klienci_id)\n" +
//                    "REFERENCES klienci(id_klient)\n" +
//                    "ON DELETE CASCADE;";
//            stmt.executeUpdate(sqlAlter);
//            String sqlAlterZamEle = "ALTER TABLE IF not EXISTS public.elementyzamowienia\n" +
//                    "ADD CONSTRAINT constraint_fk\n" +
//                    "FOREIGN KEY (zam_numer)\n" +
//                    "REFERENCES zamowienia(zam_numer)\n" +
//                    "ON DELETE CASCADE;";
//            stmt.executeUpdate(sqlAlterZamEle);
//            String sqlUpdatePrimaryProdukty= "ALTER TABLE Produkty\n" +
//                    "ADD Primary Key(prod_id)\n";
//            stmt.executeUpdate(sqlUpdatePrimaryProdukty);
            String sqlAlterElePro = "ALTER TABLE Produkty\n" +
                    "ADD CONSTRAINT EleProdukty_fk\n" +
                    "FOREIGN KEY (zam_element)\n" +
                    "REFERENCES produkty(prod_id)\n" +
                    "ON DELETE CASCADE;";
            stmt.executeUpdate(sqlAlterElePro);
//            String sqlUpdatePrimaryDostawcy= "ALTER TABLE Dostawcy\n" +
//                    "ADD Primary Key(dost_id)\n";
//            stmt.executeUpdate(sqlUpdatePrimaryDostawcy);
//            String sqlAlterProDos = "ALTER TABLE Dostawcy\n" +
//                    "ADD CONSTRAINT ProDos_fk\n" +
//                    "FOREIGN KEY (dost_id)\n" +
//                    "REFERENCES Produkty(dost_id)\n" +
//                    "ON DELETE CASCADE;";
//            stmt.executeUpdate(sqlAlterProDos);

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
