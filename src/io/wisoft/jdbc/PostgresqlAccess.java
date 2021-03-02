package io.wisoft.jdbc;

import java.sql.*;

public class PostgresqlAccess {

    private static Connection conn = null;

    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        String url = "jdbc:postgresql://arjuna.db.elephantsql.com:5432/bijdlile";
        String username = "bijdlile";
        String password = "QYdOIlgomeiV3LAxuqwwAnsm2nRiznmZ";

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
