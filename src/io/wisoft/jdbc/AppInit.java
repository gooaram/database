package io.wisoft.jdbc;

import java.sql.*;

public class AppInit {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://arjuna.db.elephantsql.com:5432/bijdlile", "bijdlile", "QYdOIlgomeiV3LAxuqwwAnsm2nRiznmZ");

            Statement stmt;
            stmt = conn.createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM STUDENT");

            if (stmt.execute("SELECT * FROM STUDENT")) {
                rs = stmt.getResultSet();
            }

            while (rs.next()) {
                System.out.print("[학번]" + rs.getString(1) + " || ");
                System.out.print("[이름]" + rs.getString(2) + " || ");
                System.out.println("[생일]" + rs.getString(3));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
    }

}