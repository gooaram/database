package io.wisoft.jdbc;

import io.wisoft.jdbc.quiz.PostgresqlAccess;

import java.sql.*;

public class StudentSelectService {

    public void getStudentAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = PostgresqlAccess.getConnection();
            conn.setAutoCommit(false);

            String query = "SELECT * FROM STUDENT";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.print("[학번] " + rs.getString(1) + " || ");
                System.out.print("[이름] " + rs.getString(2) + " || ");
                System.out.println("[생일] " + rs.getString(3));
            }
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        } finally {
            if (rs != null) { try {rs.close(); } catch (Exception e) { e.printStackTrace(); }}
            if (pstmt != null) { try {pstmt.close(); } catch (Exception e) { e.printStackTrace(); }}
            if (conn != null) { try {conn.close(); } catch (Exception e) { e.printStackTrace(); }}
        }
    }

    public void getStudentByNo(String studentNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = PostgresqlAccess.getConnection();
            conn.setAutoCommit(false);

            String query = "SELECT * FROM STUDENT WHERE NO=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, studentNo);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.print("[학번] " + rs.getString(1) + " || ");
                System.out.print("[이름] " + rs.getString(2) + " || ");
                System.out.println("[생일] " + rs.getString(3));
            }


        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        } finally {
            if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
            if (pstmt != null) { try {pstmt.close();} catch (Exception e) {e.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
        }
    }

    public void getStudentByName(String studentName) {
        String query = "SELECT * FROM STUDENT WHERE NAME=?";

        try (Connection conn = PostgresqlAccess.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setString(1, studentName);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    printStudent(rs);
                }
            }
        } catch (SQLException sqex) {
            printSQLException(sqex);
        }
    }

    public void getStudentByBirthday(String studentBirthday) {
        String query = "SELECT * FROM STUDENT WHERE birthday = '"+studentBirthday+"'";

        try (Connection conn = PostgresqlAccess.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                printStudent(rs);
            }
        } catch (SQLException sqex) {
            printSQLException (sqex);
        }

    }

    private void printStudent(final ResultSet rs) throws SQLException {
        System.out.print("[학번] " + rs.getString(1) + " || ");
        System.out.print("[이름] " + rs.getString(2) + " || ");
        System.out.println("[생일] " + rs.getString(3));
    }

    private void printSQLException(final SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
    }

}
